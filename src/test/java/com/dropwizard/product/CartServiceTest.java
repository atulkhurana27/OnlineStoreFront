package com.dropwizard.product;

import com.OnlineStore.CartService.DiscountHandler;
import com.OnlineStore.db.DepartmentDAO;
import com.OnlineStore.db.ProductDAO;

import com.OnlineStore.models.CartResponseBody;
import com.OnlineStore.models.Item;
import com.OnlineStore.models.Rule;
import com.OnlineStore.models.RuleConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;


public class CartServiceTest

{
    private static ProductDAO productDAO = mock(ProductDAO.class);
    private static DepartmentDAO departmentDAO = mock(DepartmentDAO.class);
    private static DiscountHandler discountHandler = new DiscountHandler(productDAO,departmentDAO);
    List<Rule> ruleList = null;

    @Test
    public void testRulesLoader() throws Exception
    {
         ruleList=discountHandler.loadRules();
        String expected = "[{\"ruleName\":\"Five_Items_Same_Department_Reduce_overall_cost_10_percent\",\"ruleKey\":\"DEPARTMENT\",\"ruleScope\":\"MINCOUNT\",\"ruleType\":\"QUANTITY\",\"ruleOperation\":\"PERCENTAGE\",\"comparisonValue\":5.0,\"dealValue\":10.0},{\"ruleName\":\"More_than_ten_single_item_Reduce_overall_cost_10_percent\",\"ruleKey\":\"ITEM\",\"ruleScope\":\"PERCENTAGE\",\"ruleType\":\"QUANTITY\",\"ruleOperation\":\"MINCOUNT\",\"comparisonValue\":10.0,\"dealValue\":10.0},{\"ruleName\":\"Total_Cost_Greater_Than_50\",\"ruleKey\":\"OVERALL\",\"ruleScope\":\"OVERALL\",\"ruleType\":\"COST\",\"ruleOperation\":\"PRICE\",\"comparisonValue\":50.0,\"dealValue\":5.0},{\"ruleName\":\"Buy_one_get_second_50_percent_off\",\"ruleKey\":\"ITEM\",\"ruleScope\":\"COUNT\",\"ruleType\":\"QUANTITY\",\"ruleOperation\":\"PERCENTAGE\",\"comparisonValue\":2.0,\"dealValue\":50.0}]";
        String result = new ObjectMapper().writeValueAsString(ruleList);
        Assert.assertEquals(expected,result);

    }

    @Test
    public void testItemRules() throws Exception{
        Item item =  new Item();
        item.setBasePrice(123.0);
        item.setQuantity(12L);
        List<Item> list= new ArrayList<>();
        list.add(item);
        CartResponseBody cartResponseBody = new CartResponseBody();
        cartResponseBody.setDiscounts(new HashSet<String>());
        ruleList = discountHandler.loadRules();
        List<Item> items = discountHandler.applyItemRule(list,ruleList.get(3),cartResponseBody);
        Item result = items.get(0);
        Assert.assertEquals(Double.valueOf(738.0),result.getTotalPrice());

    }

    @Test
    public void testDepartmentRules() throws Exception{
        CartResponseBody cartResponseBody = new CartResponseBody();
        cartResponseBody.setDiscounts(new HashSet<String>());
        ruleList = discountHandler.loadRules();
        Double result = discountHandler.applyDepartRule(Double.valueOf(224.0),7,ruleList.get(0),cartResponseBody);
        Assert.assertEquals(Double.valueOf(201.6),result);
    }

    @Test
    public void testOverAllRules() throws  Exception {
        CartResponseBody cartResponseBody = new CartResponseBody();
        cartResponseBody.setDiscounts(new HashSet<String>());
        ruleList = discountHandler.loadRules();
        List<Rule> rules = new ArrayList<>();
        ruleList = ruleList.stream().filter(rule -> rule.getRuleKey().equals(RuleConstants.OVERALL)).collect(Collectors.toList());
        Double price = discountHandler.applyOverAllRules(55.0,ruleList,cartResponseBody);
        Assert.assertEquals(Double.valueOf(50.0),price);
    }
}
