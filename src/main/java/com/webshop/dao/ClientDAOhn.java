package com.webshop.dao;

import com.webshop.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
        Client c=null;
        String req="SELECT c FROM Client c WHERE login='"+login+"'";
        try {
            Query query = em.createQuery(req);
            c=(Client)query.getSingleResult();
        }
        catch (NoResultException e)
        {}
        finally {
            return c;
        }
    }

    @Override
    public void removeClient(Client c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }
}
