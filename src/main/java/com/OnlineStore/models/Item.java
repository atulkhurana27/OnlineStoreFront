package com.OnlineStore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("quantity")
    private Long quantity;

    @JsonIgnore
    private Double basePrice;

    @JsonIgnore
    private String department;

    @JsonIgnore
    private Double totalPrice;

    public Item() {
    }

    public Item(Long productId, Long quantity, Double basePrice, String department, Double totalPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.basePrice = basePrice;
        this.department = department;
        this.totalPrice = totalPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
