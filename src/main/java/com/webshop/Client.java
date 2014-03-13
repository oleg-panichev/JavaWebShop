package com.webshop;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Oleg on 25.02.14.
 */
@Entity
@Table(name="CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;
    private String login;
    private String pass;
    private int clientStatus;
    @OneToMany(mappedBy = "client")
    private Collection<Item> orders=new ArrayList<Item>();

    @Transient
    public static final int STATUS_ADMIN=1;
    @Transient
    public static final int STATUS_MODERATOR=2;
    @Transient
    public static final int STATUS_USER=3;

    public Client() {
    }

    public Client(String login, String pass, int clientStatus) {
        this.login = login;
        this.pass = pass;
        this.clientStatus = clientStatus;
//        this.orders
    }

    public Client(String login, String pass) {
        this.login=login;
        this.pass=pass;
        this.clientStatus=STATUS_USER;
    }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getClientStatus() { return clientStatus; }
    public void setClientStatus(int userStatus) { this.clientStatus = userStatus; }

    public Collection<Item> getOrders() {
        return orders;
    }
    public void setOrders(List<Item> orders) {
        this.orders = orders;
    }

    public boolean checkPass(String pass) {
        if (this.pass.equals(pass))
            return true;
        else
            return false;
    }

    public void addOrder(Item i) {
        orders.add(i);
    }

    public int getNumberOfOrders() {
        return orders.size();
    }

    public void setUserAdminStatus() {
        clientStatus=STATUS_ADMIN;
    }

    public void setUserModeratorStatus() {
        clientStatus=STATUS_MODERATOR;
    }
}
