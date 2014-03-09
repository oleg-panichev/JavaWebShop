package com.webshop.db;

import com.webshop.Client;

import javax.persistence.EntityManager;

/**
 * Created by Oleg on 08.03.14.
 */
public class ClientDAOhn implements ClientDAO {
    EntityManager em;

    public ClientDAOhn(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addClient(Client c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    @Override
    public void updateClient(Client c) {
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    @Override
    public Client getClient(int id) {
        return em.find(Client.class,id);
    }

    @Override
    public Client getClient(String login) {
        return em.find(Client.class,login);
    }

    @Override
    public void removeClient(Client c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }
}
