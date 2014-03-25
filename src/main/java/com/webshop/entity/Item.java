package com.webshop.entity;

import javax.persistence.*;

/**
 * Created by Oleg on 28.02.14.
 */
@Entity
@Table(name="ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private int itemPrice;
    @ManyToOne
    @JoinColumn(name="clientId")
    private Client client;

    public Item() {
    }

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

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public void removeClient() { this.client=null; }

    public String prepareDataForWebTable() {
        return ("<td>"+itemName+"</td><td>"+itemPrice+"$</td>");
    }

}
