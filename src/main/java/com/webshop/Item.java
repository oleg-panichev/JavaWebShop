package com.webshop;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Oleg on 28.02.14.
 */
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private int itemPrice;

    public Item(String itemName, int itemPrice) {
        this.itemName=itemName;
        this.itemPrice=itemPrice;
    }

    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int itemPrice) { this.itemPrice = itemPrice; }

    public String prepareDataForWebTable() {
        return ("<td>"+itemName+"</td><td>"+itemPrice+"</td>");
    }

}
