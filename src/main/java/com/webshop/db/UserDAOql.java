package com.webshop.db;

import com.webshop.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Oleg on 26.02.14.
 */
public class UserDAOql implements UserDAO {
    private Connection con;
    private PreparedStatement stmt;
    private static final String addUser="INSERT INTO users (login,password) VALUES (?,?)";
    private static final String getUserById="SELECT login,password FROM users WHERE id=?";
    private static final String getUserByLogin="SELECT login,password FROM users WHERE id=?";

    public UserDAOql(Connection con) {
        this.con=con;
    }

    @Override
    public void addUser(User u) {
        try {
            stmt=con.prepareStatement(addUser);
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
            stmt=con.prepareStatement(getUserById);
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
            stmt=con.prepareStatement(getUserByLogin);
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
