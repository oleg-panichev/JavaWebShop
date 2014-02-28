package com.webshop;

/**
 * Created by Oleg on 28.02.14.
 */
public class Item {
    private String itemName;
    private int itemPrice;

    public Item(String itemName, int itemPrice) {
        this.itemName=itemName;
        this.itemPrice=itemPrice;
    }

    public String prepareDataForWebTable() {
        return ("<tr><td>"+itemName+"</td><td>"+itemPrice+"</td></tr>");
    }

}
