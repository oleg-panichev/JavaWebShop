package com.webshop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 25.02.14.
 */
public class User {
    Integer userId;
    String name;
    String pass;
    List<Order> orders=new ArrayList<>();

}
