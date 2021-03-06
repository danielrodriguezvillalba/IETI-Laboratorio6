/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Controllers;

import edu.eci.ieti.Services.TaskService;
import edu.eci.ieti.Services.UserService;
import edu.eci.ieti.model.Task;
import edu.eci.ieti.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danie
 */
@RestController
@RequestMapping(value = "/Tasks")
public class TaskController {
    @Autowired
    private TaskService taskServices;
    
    @Autowired
    private UserService userServices;
    
     @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> geAllTasks() {
        try {
            return new ResponseEntity<>(taskServices.geAll(), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo traer las tareas", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable String taskId) {
        try {
            return new ResponseEntity<>(taskServices.getById(taskId), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo traer la tarea", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable String userId) {
        try {
            return new ResponseEntity<>(taskServices.getByUserId(userId), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo traer las tareas de este usuario", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{userId}/{taskId}")
    public ResponseEntity<?> assignTaskToUser(@PathVariable String userId, @PathVariable String taskId) {
        try {
            User us = userServices.getById(userId);
            return new ResponseEntity<>(taskServices.assignTaskToUser(taskId, us), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo asignar la tarea al usuario", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{taskId}")
    public ResponseEntity<?> removeTask(@PathVariable String taskId) {
        try {
            taskServices.remove(taskId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo elimina la tarea", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable String taskId) {
        try {
            Task task = taskServices.getById(taskId);
            return new ResponseEntity<>(taskServices.update(task), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo ctualizar la tarea", HttpStatus.FORBIDDEN);
        }
    }

}
