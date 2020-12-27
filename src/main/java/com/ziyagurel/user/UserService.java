package com.ziyagurel.user;

import com.ziyagurel.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDatabase userDatabase;

    public User getUserById(long id) {
        return this.userDatabase.findById(id).orElseThrow(() -> new NotFoundException("User does not exist"));
    }

    public User save(User user) {
        return this.userDatabase.save(user);    
    }
}
