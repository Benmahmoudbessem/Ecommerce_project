package org.example.ecommerce.controller;

import org.example.ecommerce.entity.User;
import org.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserRestController {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userService.createUser(user);   }
}
