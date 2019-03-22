package com.mycompany.myapp.kiaf.service.impl;

import com.mycompany.myapp.kiaf.dao.OrderDao;
import com.mycompany.myapp.kiaf.entity.Order;
import com.mycompany.myapp.kiaf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by keda on 2019/3/21.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Order saveOrder(Long userId, Long filmId, String filmName, BigDecimal filmPrice) {
        Order order = new Order();
        order.setUserId(userId);
        order.setFilmId(filmId);
        order.setFilmName(filmName);
        order.setFilmPrice(filmPrice);
        return orderDao.save(order);
    }
}
