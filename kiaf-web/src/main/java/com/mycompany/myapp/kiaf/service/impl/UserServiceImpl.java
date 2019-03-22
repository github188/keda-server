package com.mycompany.myapp.kiaf.service.impl;

import com.mycompany.myapp.kiaf.dao.BillDao;
import com.mycompany.myapp.kiaf.dao.OrderDao;
import com.mycompany.myapp.kiaf.dao.UserDao;
import com.mycompany.myapp.kiaf.entity.Bill;
import com.mycompany.myapp.kiaf.entity.Order;
import com.mycompany.myapp.kiaf.entity.User;
import com.mycompany.myapp.kiaf.service.UserService;
import com.mycompany.myapp.kiaf.utils.Const;
import com.mycompany.myapp.kiaf.utils.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by keda on 2019/3/21.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BillDao billDao;
    @Autowired
    private OrderDao orderDao;

    public User findById(Long id){
        return userDao.getOne(id);
    }

    @Override
    public User login(String name, String password) {
        return userDao.findByNameAndPassword(name,password);
    }


    public boolean updateBalance(BigDecimal amount,BigDecimal balance,Long id) {
        Boolean flag = true;
        System.out.println("新的余额" + balance);
        if(userDao.updateUser(balance,id)<0){
            flag = false;
        };
        Bill bill= new Bill();
        bill.setUserId(id);
        bill.setMoney(amount);
        bill.setContent(Const.CONTENT_RECHARGE+amount);
        bill.setType(1);//1代表余额增加,0代表余额减少
        if(EmptyUtils.isEmpty(billDao.save(bill))){
            flag = false;
        };
        return flag;
    }

    @Override
    public boolean updateUserAndBillAndOrder(BigDecimal balance, Long userId, BigDecimal money, Long filmId, String filmName) {
        Boolean flag = true;
        if(userDao.updateUser(balance,userId)<0){
            flag = false;
        };
        Bill bill= new Bill();
        bill.setUserId(userId);
        bill.setMoney(money);
        bill.setContent(Const.CONTENT_BUY+filmName);
        bill.setType(0);//1代表余额增加,0代表余额减少
       if(EmptyUtils.isEmpty(billDao.save(bill))){
           flag = false;
       };
        Order order = new Order();
        order.setUserId(userId);
        order.setFilmId(filmId);
        order.setFilmName(filmName);
        order.setFilmPrice(money);
        if(EmptyUtils.isEmpty(orderDao.save(order))){
            flag = false;
        };

       return flag;
    }
}
