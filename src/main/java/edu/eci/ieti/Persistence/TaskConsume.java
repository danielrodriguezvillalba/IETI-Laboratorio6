/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Persistence;

import edu.eci.ieti.model.Task;
import edu.eci.ieti.model.User;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */
@Service
public interface TaskConsume {

    List<Task> geAll();

    Task getById(String id);

    List<Task> getByUserId(String userId);

    Task assignTaskToUser(String taskId, User user);

    void remove(String taskId);

    Task update(Task task);
}
