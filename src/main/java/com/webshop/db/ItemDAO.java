package com.webshop.db;

import com.webshop.Item;

import java.util.List;

/**
 * Created by Oleg on 08.03.14.
 */
public interface ItemDAO {
    public void addItem(Item i);
    public void updateItem(Item i);
    public Item getItem(int itemId);
    public List<Item> getAllItems();
    public void removeItem(Item i);
}
