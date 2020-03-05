/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Services.impl;

import edu.eci.ieti.Persistence.UserConsume;
import edu.eci.ieti.Services.UserService;
import edu.eci.ieti.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danie
 */
public class UserServiceImpl implements UserService{

    @Autowired
    UserConsume userConsume= null;
    
    @Override
    public List<User> getAll() {
        return userConsume.getAll();
    }

    @Override
    public User getById(String userId) {
        return userConsume.getById(userId);
    }

    @Override
    public User create(User user) {
        return userConsume.create(user);
    }

    @Override
    public User update(User user) {
        return userConsume.update(user);
    }

    @Override
    public void remove(String userId) {
        userConsume.remove(userId);
    }
    
}
