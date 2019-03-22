package com.mycompany.myapp.kiaf.service.impl;

import com.mycompany.myapp.kiaf.dao.BillDao;
import com.mycompany.myapp.kiaf.entity.Bill;
import com.mycompany.myapp.kiaf.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by keda on 2019/3/21.
 */
@Service
@Transactional
public class BillServiceImpl implements BillService {
    @Autowired
    private BillDao billDao;
    @Override
    public Bill saveBill(Long userId, BigDecimal money, String content, int type) {
        Bill bill= new Bill();
        bill.setUserId(userId);
        bill.setMoney(money);
        bill.setContent(content);
        bill.setType(type);
        return billDao.save(bill);
    }
}
