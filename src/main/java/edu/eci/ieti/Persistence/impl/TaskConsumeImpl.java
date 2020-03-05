/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Persistence.impl;

import edu.eci.ieti.Persistence.TaskConsume;
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
public class TaskConsumeImpl implements TaskConsume{
    
    private HashMap<String,Task> tareas = new HashMap<>();

    @Override
    public List<Task> geAll() {
        ArrayList<Task>res = new ArrayList<>();
        for (Map.Entry<String, Task> entrySet : tareas.entrySet()) {
            Task value = entrySet.getValue();
            res.add(value);
        }
        return res;
    }

    @Override
    public Task getById(String id) {
       return tareas.get(id);
    }

    @Override
    public List<Task> getByUserId(String userId) {
       ArrayList<Task>res = new ArrayList<>();
        for (Map.Entry<String, Task> entrySet : tareas.entrySet()) {
            Task value = entrySet.getValue();
            if(value.getResponsable().getUserId().equals(userId)){
                res.add(value);
            }
            
        }
        return res;
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {
        Task ts = tareas.get(taskId);
        ts.setResponsable(user);
        return ts;
    }

    @Override
    public void remove(String taskId) {
        if (tareas.get(taskId) != null){
            tareas.remove(taskId);
        }
    }

    @Override
    public Task update(Task task) {
        if(tareas.get(task.getTaskId())!= null){
            tareas.replace(task.getTaskId(), task);
        }
        return task;
    }
    
}
