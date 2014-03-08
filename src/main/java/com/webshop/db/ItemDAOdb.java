package com.webshop.db;

import com.webshop.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 28.02.14.
 */
public class ItemDAOdb implements ItemDAO{
    private Connection con;

    public ItemDAOdb(Connection con) {
        this.con=con;
    }

    @Override
    public void addItem(Item i) {

    }

    @Override
    public void updateItem(Item i) {

    }

    @Override
    public Item getItem(int itemId) {
        return null;
    }

    public List<Item> getAllItems() {
        List<Item> itemList=new ArrayList<Item>();
        try {
            PreparedStatement stmt=con.prepareStatement("SELECT itemname,itemprice FROM goods");
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                itemList.add(new Item(rs.getString("itemname"),rs.getInt("itemprice")));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public void removeItem(Item i) {

    }
}
