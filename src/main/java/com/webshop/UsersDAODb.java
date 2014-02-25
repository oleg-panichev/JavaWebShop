package com.webshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Oleg on 26.02.14.
 */
public class UsersDAODb {
    private Connection con;
    private PreparedStatement stmt;

    public UsersDAODb(Connection con) {
        this.con=con;
    }

    public boolean addUser(String name, String pass) {
        try {
            stmt=con.prepareStatement("INSERT INTO users (name,password)" +
                    "VALUES (?,?)");
            stmt.setString(1,name);
            stmt.setString(2,pass);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean findUser(String name) {
        try {
            stmt=con.prepareStatement("SELECT name,password FROM users WHERE name=?");
            stmt.setString(1,name);
            ResultSet Rs=stmt.executeQuery();
            while()
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
