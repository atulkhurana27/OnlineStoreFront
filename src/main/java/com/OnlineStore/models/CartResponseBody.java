package com.OnlineStore.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class CartResponseBody {

    @JsonProperty("cart_overall_cost")
    private Double cartOverallCost;

    @JsonProperty("discounts")
    Set<String> discounts;

    @JsonProperty("cart_id")
    Long cartId;

    public CartResponseBody() {
    }

    public CartResponseBody(Double cartOverallCost, Set<String> discounts, Long cartId) {
        this.cartOverallCost = cartOverallCost;
        this.discounts = discounts;
        this.cartId = cartId;
    }

    public Double getCartOverallCost() {
        return cartOverallCost;
    }

    public void setCartOverallCost(Double cartOverallCost) {
        this.cartOverallCost = cartOverallCost;
    }

    public Set<String> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Set<String> discounts) {
        this.discounts = discounts;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
