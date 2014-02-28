package com.webshop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 25.02.14.
 */
public class User {
    private String login;
    private String pass;
    List<Order> orders=new ArrayList<Order>();

    public User(String login, String pass) {
        this.login=login;
        this.pass=pass;
    }

    public boolean checkPass(String pass) {
        if (this.pass.equals(pass))
            return true;
        else
            return false;
    }
}
