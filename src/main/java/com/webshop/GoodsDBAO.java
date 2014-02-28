package com.webshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 28.02.14.
 */
public class GoodsDBAO {
    private Connection con;

    public GoodsDBAO(Connection con) {
        this.con=con;
    }

    public List<Item> getAllGoods() {
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
}
