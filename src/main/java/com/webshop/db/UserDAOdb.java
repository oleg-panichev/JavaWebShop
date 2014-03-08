package com.webshop.db;

import com.webshop.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Oleg on 26.02.14.
 */
public class UserDAOdb implements UserDAO {
    private Connection con;
    private PreparedStatement stmt;

    public UserDAOdb(Connection con) {
        this.con=con;
    }

    @Override
    public void addUser(User u) {
        try {
            stmt=con.prepareStatement("INSERT INTO users (login,password)" +
                    "VALUES (?,?)");
            stmt.setString(1,u.getLogin());
            stmt.setString(2,u.getPass());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
        }
    }

    @Override
    public void updateUser(User u) {

    }

    @Override
    public User getUser(int id) {
        User u=null;
        try {
            stmt=con.prepareStatement("SELECT login,password FROM users WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                u=new User(rs.getString("login"),rs.getString("password"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public User getUser(String login) {
        User u=null;
        try {
            stmt=con.prepareStatement("SELECT login,password FROM users WHERE id=?");
            stmt.setString(1, login);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                u=new User(rs.getString("login"),rs.getString("password"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public void removeUser(User u) {

    }
}
