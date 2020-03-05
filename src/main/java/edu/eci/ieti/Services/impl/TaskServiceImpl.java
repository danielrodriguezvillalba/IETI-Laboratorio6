/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Services.impl;

import edu.eci.ieti.Persistence.TaskConsume;
import edu.eci.ieti.Services.TaskService;
import edu.eci.ieti.Services.UserService;
import edu.eci.ieti.model.Task;
import edu.eci.ieti.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danie
 */
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    TaskConsume taskConsume = null;

    @Override
    public List<Task> geAll() {
        return taskConsume.geAll();
    }

    @Override
    public Task getById(String id) {
        return taskConsume.getById(id);
    }

    @Override
    public List<Task> getByUserId(String userId) {
        return taskConsume.getByUserId(userId);
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {
        return taskConsume.assignTaskToUser(taskId, user);
    }

    @Override
    public void remove(String taskId) {
        taskConsume.remove(taskId);
    }

    @Override
    public Task update(Task task) {
        return taskConsume.update(task);
    }
    
}
