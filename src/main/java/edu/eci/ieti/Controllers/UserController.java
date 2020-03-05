/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Controllers;

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
@RequestMapping(value = "/User")
public class UserController {
    @Autowired
    private UserService userServices;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> geAllUsers() {
        try {
            return new ResponseEntity<>(userServices.getAll(), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo traer los usuarios", HttpStatus.FORBIDDEN);
        }
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable String userId) {
        try {
            return new ResponseEntity<>(userServices.getById(userId), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo traer el usuario con este id", HttpStatus.FORBIDDEN);
        }
    }

   @RequestMapping(method = RequestMethod.PUT, path = "/{userId}/{userCorreo}/{userFullName}")
    public ResponseEntity<?> createUser(@PathVariable String userId,@PathVariable String userCorreo,@PathVariable String userFullName) {
        try {
            User  us = new User(userId,userFullName,userCorreo);
            return new ResponseEntity<>(userServices.create(us),HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo crear el usuario", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{userId}")
    public ResponseEntity<?> removeUser(@PathVariable String userId) {
        try {
            userServices.remove(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo elimina el usuario", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId) {
        try {
            User us = userServices.getById(userId);
            return new ResponseEntity<>(userServices.update(us), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo ctualizar la tarea", HttpStatus.FORBIDDEN);
        }
    }
}
