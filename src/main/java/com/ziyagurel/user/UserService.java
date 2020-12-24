package com.ziyagurel.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDatabase userDatabase;

    public User getUserById(long id) {
        return this.userDatabase.findById(id).get();
    }
}
