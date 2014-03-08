package com.webshop.db;

import javax.persistence.EntityManager;

/**
 * Created by Oleg on 08.03.14.
 */
public class HnDAOFactory extends DAOFactory {
    private EntityManager em;

    public HnDAOFactory() {
        this.em=EntityManagerSingleton.getEMs();
    }

    @Override
    public ClientDAO getUserDAO() {
        return new ClientDAOhn(em);
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
