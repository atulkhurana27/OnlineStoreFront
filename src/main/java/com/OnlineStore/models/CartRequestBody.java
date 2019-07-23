package com.OnlineStore.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CartRequestBody {

    @JsonProperty("item_list")
    private List<Item> itemList;

    public CartRequestBody() {
    }

    public CartRequestBody(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}


