package com.ziyagurel.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDatabase extends JpaRepository<User, Long> {

}
