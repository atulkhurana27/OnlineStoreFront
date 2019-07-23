package com.OnlineStore.models;


import com.OnlineStore.Utils.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    @JsonProperty("product_id")
    private Long productId;

    @Column(name = "color", nullable = false)
    @JsonProperty("color")
    private String color;

    @Column(name = "isbn", nullable = false)
    @JsonProperty("isbn")
    private String isbn;

    @Column(name = "like_products")
    @JsonProperty("like_products")
    @ElementCollection
    private List<Long> likeProducts;

    @Column(name = "active", nullable = false)
    @JsonProperty("active")
    private Boolean active;

    @Column(name = "product_title", nullable = false)
    @JsonProperty("product_title")
    private String productTitle;

    @Column(name = "product_subtitle", nullable = false)
    @JsonProperty("product_subtitle")
    private String productSubtitle;

    @Column(name = "lifecycle_start", nullable = false)
    @JsonProperty("lifecycle_start")
    private Date lifecycleStart;

    @Column(name = "lifecycle_end", nullable = false)
    @JsonProperty("lifecycle_end")
    private Date lifecycleEnd;

    @Column(name = "company", nullable = false)
    @JsonProperty("company")
    private String company;

    @Column(name = "attributes")
    private String attributes;

    @Column(name = "current_price", nullable = false)
    @JsonProperty("current_price")
    private Double currentPrice;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "name")
    private Department department;

    @Column(name = "product_description")
    @JsonProperty("product_description")
    private String productDescription;

    public Product() {
    }

    public Product(String color, String isbn, List<Long> likeProducts, Boolean active, String productTitle, String productSubtitle, Date lifecycleStart, Date lifecycleEnd, String company, String attributes, Double currentPrice, Department department, String productDescription) {
        this.color = color;
        this.isbn = isbn;
        this.likeProducts = likeProducts;
        this.active = active;
        this.productTitle = productTitle;
        this.productSubtitle = productSubtitle;
        this.lifecycleStart = lifecycleStart;
        this.lifecycleEnd = lifecycleEnd;
        this.company = company;
        this.attributes = attributes;
        this.currentPrice = currentPrice;
        this.department = department;
        this.productDescription = productDescription;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Long> getLikeProducts() {
        if(this.likeProducts==null)
            likeProducts = new ArrayList<>();
        return likeProducts;
    }

    public void setLikeProducts(List<Long> likeProducts)
    {
        this.likeProducts= likeProducts;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductSubtitle() {
        return productSubtitle;
    }

    public void setProductSubtitle(String productSubtitle) {
        this.productSubtitle = productSubtitle;
    }

    public String getLifecycleStart() {
        return Utils.sdf.format(lifecycleStart);
    }

    public void setLifecycleStart(String lifecycleStart)  throws Exception{
        this.lifecycleStart = Utils.sdf.parse(lifecycleStart);
    }

    public String getLifecycleEnd() {
        return Utils.sdf.format(lifecycleEnd);
    }

    public void setLifecycleEnd(String lifecycleEnd) throws Exception {
        this.lifecycleEnd = Utils.sdf.parse(lifecycleEnd);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getDepartment() {
        return department.getName();
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) &&
                Objects.equals(color, product.color) &&
                Objects.equals(productTitle, product.productTitle) &&
                Objects.equals(productSubtitle, product.productSubtitle) &&
                Objects.equals(company, product.company) &&
                Objects.equals(attributes, product.attributes) &&
                Objects.equals(currentPrice, product.currentPrice) &&
                Objects.equals(department, product.department) &&
                Objects.equals(productDescription, product.productDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, color, productTitle, productSubtitle, company, attributes, currentPrice, department, productDescription);
    }

    public void addProduct(Product product){
        if(this.likeProducts==null){
            this.likeProducts = new ArrayList<>();
        }
        if(product!=null){
            this.likeProducts.add(product.getProductId());
        }
    }
}
