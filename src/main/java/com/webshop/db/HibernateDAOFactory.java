package com.webshop.db;

import javax.persistence.EntityManager;

/**
 * Created by Oleg on 08.03.14.
 */
public class HibernateDAOFactory extends DAOFactory {
    private EntityManager em;

    public HibernateDAOFactory() {
        this.em=EntityManagerSingleton.getEMs();
    }

    @Override
    public UserDAO getUserDAO() {
        return null;
    }

    @Override
    public ItemDAO getItemDAO() {
        return null;
    }

    @Override
    public OrderDAO getOrderDAO() {
        return null;
    }
}
