package com.ziyagurel.user;

import com.ziyagurel.error.ErrorPage;
import com.ziyagurel.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.NoSuchElementException;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id){
        return this.userService.getUserById(id);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorPage handleNoSuchElementException(NotFoundException exception, HttpServletRequest request){
        return new ErrorPage(404, exception.getMessage(), request.getServletPath());
    }
}
