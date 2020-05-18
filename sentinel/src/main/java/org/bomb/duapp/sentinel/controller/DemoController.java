package org.bomb.duapp.sentinel.controller;

import org.bomb.duapp.sentinel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String sayHello(String name) {
        return userService.sayHello(name);
    }

    @GetMapping("/test")
    public String test() {return userService.test();}

}
