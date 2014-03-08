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
    public UserDAO getUserDAO() {
        return new UserDAOdb(con);
    }

    @Override
    public ItemDAO getItemDAO() {
        return new ItemDAOdb(con);
    }

    @Override
    public OrderDAO getOrderDAO() {
        return new OrderDAOdb(con);
    }
}
