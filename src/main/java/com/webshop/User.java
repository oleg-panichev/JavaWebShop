package com.webshop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 25.02.14.
 */
public class User {
    private int userId;
    private String login;
    private String pass;
    private List<Order> orders=new ArrayList<Order>();

    public User(String login, String pass) {
        this.login=login;
        this.pass=pass;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean checkPass(String pass) {
        if (this.pass.equals(pass))
            return true;
        else
            return false;
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

    public int getNumberOfOrders() {
        return orders.size();
    }
}
