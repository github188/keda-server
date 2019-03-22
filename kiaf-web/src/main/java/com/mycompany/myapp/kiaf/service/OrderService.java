package com.mycompany.myapp.kiaf.service;

import com.mycompany.myapp.kiaf.entity.Order;

import java.math.BigDecimal;

/**
 * Created by keda on 2019/3/21.
 */
public interface OrderService {
    Order saveOrder(Long userId, Long filmId, String filmName, BigDecimal filmPrice);
}
