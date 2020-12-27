package com.ziyagurel.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return this.userService.save(user);
    }
}
