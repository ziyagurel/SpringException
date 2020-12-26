package com.ziyagurel.user;

import com.ziyagurel.error.ErrorPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id){
        try {
            return ResponseEntity.ok(this.userService.getUserById(id));
        }catch (Exception ex){
            ErrorPage err = new ErrorPage(404, "User Not Found", "/users/" + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        }
    }
}
