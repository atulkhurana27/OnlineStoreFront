package com.OnlineStore.CartService;

import com.OnlineStore.db.DepartmentDAO;
import com.OnlineStore.db.ProductDAO;
import com.OnlineStore.models.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


public class DiscountHandler {

    private final ProductDAO productDAO;
    private final DepartmentDAO departmentDAO;

    private static final AtomicLong cartSequence = new AtomicLong(0);

    public DiscountHandler(ProductDAO productDAO, DepartmentDAO departmentDAO) {
        this.productDAO = productDAO;
        this.departmentDAO = departmentDAO;
    }



    public  CartResponseBody  applyDiscounts(CartRequestBody cartRequestBody)  throws Exception{

        CartResponseBody cartResponseBody = new CartResponseBody();

        cartResponseBody.setCartId(cartSequence.incrementAndGet());
        cartResponseBody.setDiscounts(new HashSet<>());
        List<Item> items = cartRequestBody.getItemList();

        List<Item> itemsUpdated = new ArrayList<>();
        List<Rule> rules = loadRules();
        for (int i = 0; i < items.size(); i++) {
            Item item = (items.get(i));
            item.setBasePrice(productDAO.findById(item.getProductId()).get().getCurrentPrice());
            itemsUpdated.add(item);
        }

        items =  itemsUpdated;



        List<Rule> itemRules = rules.stream().filter(rule -> rule.getRuleKey().equals(RuleConstants.ITEM)).collect(Collectors.toList());
        List<Rule> departRules =  rules.stream().filter(rule -> rule.getRuleKey().equals(RuleConstants.DEPARTMENT)).collect(Collectors.toList());
        List<Rule> overAllRules =  rules.stream().filter(rule -> rule.getRuleKey().equals(RuleConstants.OVERALL)).collect(Collectors.toList());

        for (int i = 0; i < itemRules.size(); i++) {
            items = applyItemRule(items, itemRules.get(i), cartResponseBody);
        }

        Double cart_price = applyDepartRules(items, departRules, cartResponseBody);

        cart_price = applyOverAllRules(cart_price, overAllRules,cartResponseBody);

        cartResponseBody.setCartOverallCost(cart_price);

        return cartResponseBody;
    }

    public Double  applyOverAllRules(Double price, List<Rule> list,CartResponseBody cartResponseBody) {
        Set<String> discount = cartResponseBody.getDiscounts();
        for (int i = 0; i < list.size(); i++) {
            Rule rule = list.get(i);
            if (rule.getRuleType().equals(RuleConstants.COST)) {
                if(rule.getRuleOperation().equals(RuleConstants.PRICE)){
                    if(price>=rule.getComparisonValue()){
                        discount.add(rule.getRuleName());
                        price = price - rule.getDealValue();
                    }
                }
            }
        }
        cartResponseBody.setDiscounts(discount);
        return price;
    }

    public Double  applyDepartRules(List<Item> itemList, List<Rule> rules, CartResponseBody cartResponseBody) {
        HashMap<String, List<Item>> hashMap = new HashMap<>();
        Double result = 0.0;
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            List<Item> list = null;
            if (!hashMap.containsKey(item.getDepartment())) {
                list = new ArrayList<>();
            } else {
                list = hashMap.get(item.getDepartment());
            }
            list.add(item);
            hashMap.put(item.getDepartment(), list);
        }
        for ( List<Item> list : hashMap.values()) {
            Double price = 0.0;
            int count = list.size();
            price = list.stream().mapToDouble(i->i.getTotalPrice()).sum();
            for ( Rule rule : rules) {
               price = applyDepartRule(price,count,rule,cartResponseBody);
            }
            result +=price;
        }
        return result;
    }

    public Double applyDepartRule(Double price, int count, Rule rule, CartResponseBody cartResponseBody) {
        Set<String> discount = cartResponseBody.getDiscounts();
        if(rule.getRuleScope().equals(RuleConstants.MINCOUNT) && rule.getRuleType().equals(RuleConstants.QUANTITY)
                && rule.getRuleOperation().equals(RuleConstants.PERCENTAGE)) {
            if(count >= rule.getComparisonValue() && !rule.getRuleOperation().equals(RuleConstants.PRICE)) {
                discount.add(rule.getRuleName());
                if(!rule.getRuleOperation().equals(RuleConstants.PRICE))
                     price = price *(100-rule.getDealValue())/100;

            }
        }
        cartResponseBody.setDiscounts(discount);
        return  price;
    }
    public List<Item> applyItemRule(List<Item> itemList, Rule rule, CartResponseBody cartResponseBody) {
        List<Item> updatedItem = new ArrayList<>();
        Set<String> discount = cartResponseBody.getDiscounts();
        itemList.forEach(item -> {
            if(rule.getRuleType().equals(RuleConstants.QUANTITY) && rule.getRuleOperation().equals(RuleConstants.PERCENTAGE)) {
                if(rule.getRuleScope().equals(RuleConstants.COUNT)) {
                    long left = item.getQuantity() % rule.getComparisonValue().longValue();
                    if(left != item.getQuantity())
                        discount.add(rule.getRuleName());
                    Double price = (item.getQuantity()-left)*(item.getBasePrice()*(100-rule.getDealValue())/100) + left*item.getBasePrice();
                    item.setTotalPrice(price);
                }
                else {
                    if(item.getQuantity() >=rule.getComparisonValue())
                    {
                        discount.add(rule.getRuleName());
                        item.setBasePrice(item.getBasePrice()*((100-rule.getDealValue())/100));
                    }
                    item.setTotalPrice(item.getBasePrice()*item.getQuantity());
                }
            }
            updatedItem.add(item);
        });
        cartResponseBody.setDiscounts(discount);
        return updatedItem;
    }

    public List<Rule> loadRules()throws   Exception{
        List<Rule> ruleList = new ArrayList<>();
        FileReader filereader = new FileReader("Rules.csv");
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .build();
        List<String[]> allData = csvReader.readAll();
        for (String[] row : allData) {
            if(row.length == 7) {
                Rule rule = new Rule(row[0], RuleConstants.valueOf(row[1]),
                        RuleConstants.valueOf(row[2]), RuleConstants.valueOf(row[3]), RuleConstants.valueOf(row[4]),
                        Double.parseDouble(row[5]), Double.parseDouble(row[6]));
                ruleList.add(rule);
            }
        }
        return ruleList;
    }
}
