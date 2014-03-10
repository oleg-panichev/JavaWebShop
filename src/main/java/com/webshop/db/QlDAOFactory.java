package com.webshop.db;

import java.sql.Connection;

/**
 * Created by Oleg on 08.03.14.
 */
public class QlDAOFactory extends DAOFactory {
    private Connection con;

    public QlDAOFactory() {
        this.con=ConnectionSingleton.getConnection();
    }

    @Override
    public ClientDAO getClientDAO() {
        return new ClientDAOql(con);
    }

    @Override
    public ItemDAO getItemDAO() {
        return new ItemDAOql(con);
    }

//    @Override
//    public OrderDAO getOrderDAO() {
//        return new OrderDAOql(con);
//    }
}
