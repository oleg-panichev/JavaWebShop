package com.webshop.db;

import com.webshop.Client;

/**
 * Created by Oleg on 08.03.14.
 */
public interface ClientDAO {
    public void addClient(Client c);
    public void updateClient(Client c);
    public Client getClient(int clientId);
    public Client getClient(String login);
    public void removeClient(Client c);
}
