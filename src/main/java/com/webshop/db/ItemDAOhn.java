package com.webshop.db;

import com.webshop.Client;
import com.webshop.Item;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        Query query = em.createQuery("SELECT i FROM Item i");
        return (List<Item>) query.getResultList();
    }

    @Override
    public void removeItem(Item i) {
        em.getTransaction().begin();
        em.remove(i);
        em.getTransaction().commit();
    }
}
