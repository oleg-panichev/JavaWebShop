package com.webshop;

import javax.persistence.*;

/**
 * Created by Oleg on 25.02.14.
 */
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderId;
    @OneToOne
    Item item;
    @ManyToOne
    @JoinColumn(name="clientId")
    Client client;

    public Order(Item item) {
        this.item = item;
    }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
}
