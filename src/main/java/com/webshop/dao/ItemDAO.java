package com.webshop.dao;

import com.webshop.entity.Item;

import java.util.List;

/**
 * Created by Oleg on 08.03.14.
 */
public interface ItemDAO {
    public void addItem(Item i);
    public void updateItem(Item i);
    public Item getItem(int itemId);
    public List<Item> getAllItems();
    public List<Item> getAvailableItems();
    public void removeItem(Item i);
}
