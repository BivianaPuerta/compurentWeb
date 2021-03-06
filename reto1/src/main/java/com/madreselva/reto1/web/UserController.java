package com.madreselva.reto1.web;

import java.util.List;

import com.madreselva.reto1.model.User;
import com.madreselva.reto1.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    @GetMapping("/{email}/{password}")
    public User userAuthentication(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.userAuthentication(email, password);
    }

    @GetMapping("/{email}")
    public boolean existsEmail(@PathVariable("email") String email){
        return userService.existsEmail(email);
    }
}
