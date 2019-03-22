package com.mycompany.myapp.kiaf.service;

import com.mycompany.myapp.kiaf.entity.Bill;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by keda on 2019/3/21.
 */
public interface BillService {
    Bill saveBill(Long userId, BigDecimal money,String content,int type);
}
