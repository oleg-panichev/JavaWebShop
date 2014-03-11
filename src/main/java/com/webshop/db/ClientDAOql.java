package com.webshop.db;

import com.webshop.Client;

import java.sql.*;

/**
 * Created by Oleg on 26.02.14.
 */
public class ClientDAOql implements ClientDAO {
    private Connection con;
    private PreparedStatement stmt;
    private static final String addClient="INSERT INTO client (login,pass,clientStatus) VALUES (?,?,?)";
    private static final String updateClient="UPDATE client SET login=?,pass=?,clientStatus=? WHERE clientId=?";
    private static final String getUserById="SELECT clientId,login,pass,clientStatus FROM client WHERE clientId=?";
    private static final String getUserByLogin="SELECT clientId,login,pass,clientStatus FROM client WHERE login=?";

    public ClientDAOql(Connection con) {
        this.con=con;
    }

    @Override
    public void addClient(Client c) {
        try {
            stmt=con.prepareStatement(addClient, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,c.getLogin());
            stmt.setString(2,c.getPass());
            stmt.setInt(3,c.getClientStatus());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateClient(Client c) {
        try {
            stmt=con.prepareStatement(updateClient);
            stmt.setString(1,c.getLogin());
            stmt.setString(2,c.getPass());
            stmt.setInt(3,c.getClientStatus());
            stmt.setInt(4,c.getClientId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client getClient(int clientId) {
        Client c=null;
        try {
            stmt=con.prepareStatement(getUserById);
            stmt.setInt(1, clientId);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                c=new Client(rs.getString("login"),rs.getString("pass"));
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
            if(rs.next()) {
                c=new Client(rs.getString("login"),rs.getString("pass"));
                c.setClientId(rs.getInt("clientId"));
                c.setClientStatus(rs.getInt("clientStatus"));
            }
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
