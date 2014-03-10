package com.webshop.db;

import com.webshop.Client;
import com.webshop.Item;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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
    public Client getClient(int clientId) {
        return em.find(Client.class,clientId);
    }

    @Override
    public Client getClient(String login) {
        Query query = em.createQuery("SELECT c FROM Client c WHERE login="+login);
        return (Client) query.getSingleResult();
    }

    @Override
    public void removeClient(Client c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }
}
