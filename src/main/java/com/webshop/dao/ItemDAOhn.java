package com.webshop.dao;

import com.webshop.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 10.03.14.
 */
public class ItemDAOhn implements ItemDAO {
    EntityManager em;

    public ItemDAOhn(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addItem(Item i) {
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
    }

    @Override
    public void updateItem(Item i) {
        em.getTransaction().begin();
        em.merge(i);
        em.getTransaction().commit();
    }

    @Override
    public Item getItem(int itemId) {
        return em.find(Item.class,itemId);
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items=new ArrayList<Item>();
        try {
            Query query = em.createQuery("SELECT i FROM Item i");
            items=(List<Item>) query.getResultList();
        }
        catch (NoResultException e)
        {}
        finally {
            return items;
        }
    }

    @Override
    public List<Item> getAvailableItems() {
        List<Item> items=new ArrayList<Item>();
        try {
            Query query = em.createQuery("SELECT i FROM Item i WHERE clientId=NULL");
            items=(List<Item>) query.getResultList();
        }
        catch (NoResultException e)
        {}
        finally {
            return items;
        }
    }

    @Override
    public void removeItem(Item i) {
        em.getTransaction().begin();
        em.remove(i);
        em.getTransaction().commit();
    }
}
