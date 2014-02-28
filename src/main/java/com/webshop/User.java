package com.webshop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 25.02.14.
 */
public class User {
    private String login;
    private String pass;
    private List<Item> orders=new ArrayList<Item>();

    public User(String login, String pass) {
        this.login=login;
        this.pass=pass;
    }

    public String getLogin() {
        return login;
    }

    public List<Item> getOrders() {
        return orders;
    }

    public boolean checkPass(String pass) {
        if (this.pass.equals(pass))
            return true;
        else
            return false;
    }

    public void addOrder(Item o) {
        orders.add(o);
    }

    public int getNumberOfOrders() {
        return orders.size();
    }
}
