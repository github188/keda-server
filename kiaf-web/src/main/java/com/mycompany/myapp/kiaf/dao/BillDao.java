package com.mycompany.myapp.kiaf.dao;

import com.mycompany.myapp.kiaf.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

/**
 * Created by keda on 2019/3/21.
 */
public interface BillDao extends JpaRepository<Bill,Long> {
}
