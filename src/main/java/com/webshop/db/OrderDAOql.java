package com.webshop.db;

import com.webshop.Order;

import java.sql.Connection;

/**
 * Created by Oleg on 08.03.14.
 */
public class OrderDAOql implements OrderDAO {
    private Connection con;

    public OrderDAOql(Connection con) {
        this.con=con;
    }

    @Override
    public void addOrder(Order o) {

    }

    @Override
    public void updateOrder(Order o) {

    }

    @Override
    public Order getOrder(int orderId) {
        return null;
    }

    @Override
    public void removeOrder(Order o) {

    }
}
