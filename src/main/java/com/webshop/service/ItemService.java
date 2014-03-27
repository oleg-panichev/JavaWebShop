package com.webshop.service;

import com.webshop.dao.ClientDAOhn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Oleg on 27.03.14.
 */
public class ItemService {
    @Autowired
    private ClientDAOhn clientDao;

    @Transactional
    public Client createPerson(String name) {
        Client person = new Client();
        person.setName(name);
        clientDao.savePerson(person);
        return person;
    }

    @Transactional
    public void createPerson(String name, Address address) {
        Client person = new Client();
        person.setName(name);
        person.setAddress(address);
        clientDao.savePerson(person);
    }

    @Transactional
    public Person findPerson(String name) {
        return clientDao.findByName(name);
    }

    @Transactional
    public List<Person> findAllPersons() {
        return clientDao.findAllPersons();
    }
}
