package com.webshop;

import javax.persistence.*;

/**
 * Created by Oleg on 25.02.14.
 */
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderId;
    Item item;
    @ManyToOne
    @JoinColumn(name="userId")
    User user;

    public Order(Item item) {
        this.item = item;
    }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
