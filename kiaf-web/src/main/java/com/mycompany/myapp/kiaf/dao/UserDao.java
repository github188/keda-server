package com.mycompany.myapp.kiaf.dao;

import com.mycompany.myapp.kiaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;


/**
* Created by kedacom on 2019-03-15.
*/
public interface UserDao  extends JpaRepository<User,Long> {
    User findByNameAndPassword(String name, String password);
    @Modifying
    @Query("update User u set u.balance = ?1 where u.id = ?2")
    int updateUser(BigDecimal balance,Long id);
}