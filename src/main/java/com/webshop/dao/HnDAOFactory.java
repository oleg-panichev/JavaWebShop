package com.webshop.dao;

import com.webshop.db.EntityManagerSingleton;

import javax.persistence.EntityManager;

/**
 * Created by Oleg on 08.03.14.
 */
public class HnDAOFactory extends DAOFactory {
    private EntityManager em;

    public HnDAOFactory() {
        this.em= EntityManagerSingleton.getEMs();
    }

    @Override
    public ClientDAO getClientDAO() {
        return new ClientDAOhn(em);
    }

    @Override
    public ItemDAO getItemDAO() {
        return new ItemDAOhn(em);
    }
}
