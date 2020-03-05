/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Persistence.impl;

import edu.eci.ieti.Persistence.TaskConsume;
import edu.eci.ieti.Persistence.UserConsume;
import edu.eci.ieti.model.Task;
import edu.eci.ieti.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author danie
 */
public class UserConsumeImpl implements UserConsume {

    private HashMap<String, User> usuarios = new HashMap<>();

    @Override
    public List<User> getAll() {
        ArrayList<User> res = new ArrayList<>();
        for (Map.Entry<String, User> entrySet : usuarios.entrySet()) {
            User value = entrySet.getValue();
            res.add(value);
        }
        return (List<User>)res;
    }

    @Override
    public User getById(String id) {
        return usuarios.get(id);
    }

    @Override
    public void remove(String userId) {
        if (usuarios.get(userId) != null) {
            usuarios.remove(userId);
        }
    }

    @Override
    public User update(User user) {
        if (usuarios.get(user.getUserId()) != null) {
            usuarios.replace(user.getUserId(), user);
        }
        return user;
    }

    @Override
    public User create(User user) {
        usuarios.put(user.getUserId(), user);
        return user;
    }

    

}
