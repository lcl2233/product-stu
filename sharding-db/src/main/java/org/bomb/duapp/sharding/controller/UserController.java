package org.bomb.duapp.sharding.controller;

import org.bomb.duapp.sharding.entity.User;
import org.bomb.duapp.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/sharding/user/{id}")
    public User info(@PathVariable("id") Long id){
        return userService.info(id);
    }

    @PostMapping("/sharding/users")
    public List<User> getUsers(@RequestBody User user){
        return userService.getUsers(user);
    }

    @PutMapping("/sharding/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

}
