package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO: annotations?
@RestController // makes the class a bean AND turns responses into JSON
@RequestMapping("/users") // all requests to /users to route to this controller
// Allow Requests from React and Angular frontends
@CrossOrigin(origins = {"http://localhost:5432", "http://localhost:4200"}, allowedHeaders = "*")
public class UserController {

    //Constructor Injection
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //TODO: the method that sends back the list of Users

    @GetMapping // GET requests to /users will trigger this method
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok().body(users);
    }


}
