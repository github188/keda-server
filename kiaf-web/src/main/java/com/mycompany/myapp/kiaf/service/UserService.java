package com.mycompany.myapp.kiaf.service;

import com.mycompany.myapp.kiaf.entity.User;
import com.mycompany.myapp.kiaf.vo.UserVO;

import java.math.BigDecimal;

/**
 * Created by keda on 2019/3/21.
 */
public interface  UserService  {
    User findById(Long id);
    User login(String name, String password);
    boolean updateBalance(BigDecimal amount ,BigDecimal balance,Long id);
    boolean updateUserAndBillAndOrder(BigDecimal balance,Long userId,BigDecimal price,Long filmId,String filmName);
}
