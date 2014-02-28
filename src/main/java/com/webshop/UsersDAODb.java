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
            stmt=con.prepareStatement("INSERT INTO users (login,password)" +
                    "VALUES (?,?)");
            stmt.setString(1,name);
            stmt.setString(2,pass);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /*public boolean findUser(String name) {
        boolean result=false;
        try {
            stmt=con.prepareStatement("SELECT name,password FROM users WHERE name=?");
            stmt.setString(1,name);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                if (rs.getString("name").equals(name))
                    result=true;
            }
        } catch (SQLException e) {
        }
        return result;
    }*/

    public User findUser(String name) {
        User u=null;
        try {
            stmt=con.prepareStatement("SELECT login,password FROM users WHERE login=?");
            stmt.setString(1,name);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                if (rs.getString("login").equals(name))
                    u=new User(rs.getString("login"),rs.getString("password"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public boolean checkPass(String name, String pass) {
        boolean result=false;
        try {
            stmt=con.prepareStatement("SELECT login,password FROM users WHERE login=?");
            stmt.setString(1,name);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                if (rs.getString("name").equals(name) && rs.getString("password").equals(pass))
                    result=true;
            }
            stmt.close();
        } catch (SQLException e) {
        }
        return result;
    }
}
