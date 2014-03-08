package com.webshop.db;

import com.webshop.User;

/**
 * Created by Oleg on 08.03.14.
 */
public interface UserDAO {
    public void addUser(User u);
    public void updateUser(User u);
    public User getUser(int id);
    public User getUser(String login);
    public void removeUser(User u);
}
