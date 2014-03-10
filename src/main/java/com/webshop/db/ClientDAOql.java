package com.webshop.db;

import com.webshop.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Oleg on 26.02.14.
 */
public class ClientDAOql implements ClientDAO {
    private Connection con;
    private PreparedStatement stmt;
    private static final String addClient="INSERT INTO client (login,password) VALUES (?,?)";
    private static final String updateClient="UPDATE client VALUES ";
    private static final String getUserById="SELECT login,password FROM client WHERE id=?";
    private static final String getUserByLogin="SELECT login,password FROM client WHERE id=?";

    public ClientDAOql(Connection con) {
        this.con=con;
    }

    @Override
    public void addClient(Client c) {
        try {
            stmt=con.prepareStatement(addClient);
            stmt.setString(1,c.getLogin());
            stmt.setString(2,c.getPass());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
        }
    }

    @Override
    public void updateClient(Client c) {


    }

    @Override
    public Client getClient(int clientId) {
        Client c=null;
        try {
            stmt=con.prepareStatement(getUserById);
            stmt.setInt(1, clientId);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                c=new Client(rs.getString("login"),rs.getString("password"));
            }
            c.setClientId(rs.getInt("clientId"));
            c.setClientStatus(rs.getInt("clientStatus"));
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Client getClient(String login) {
        Client c=null;
        try {
            stmt=con.prepareStatement(getUserByLogin);
            stmt.setString(1, login);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                c=new Client(rs.getString("login"),rs.getString("password"));
            }
            c.setClientId(rs.getInt("clientId"));
            c.setClientStatus(rs.getInt("clientStatus"));
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public void removeClient(Client c) {

    }
}
