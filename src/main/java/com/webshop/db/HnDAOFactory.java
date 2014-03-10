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
    public ClientDAO getClientDAO() {
        return new ClientDAOhn(em);
    }

    @Override
    public ItemDAO getItemDAO() {
        return new ItemDAOhn(em);
    }

    @Override
    public OrderDAO getOrderDAO() {
        return null;
    }
}
