package com.webshop.db;

import com.webshop.Order;

/**
 * Created by Oleg on 08.03.14.
 */
public interface OrderDAO {
    public void addOrder(Order o);
    public void updateOrder(Order o);
    public Order getOrder(int orderId);
    public void removeOrder(Order o);
}
