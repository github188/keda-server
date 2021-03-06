package com.mycompany.myapp.kiaf.entity;

import com.kedacom.kidp.base.data.common.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by keda on 2019/3/21.
 */
@Entity
@Data
@Table(name = "order_table")
@EntityListeners(AuditingEntityListener.class)
public class Order extends BaseEntity{
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "film_id")
    private Long filmId;
    @Column(name = "film_name")
    private String filmName;
    @Column(name="film_price")
    private BigDecimal filmPrice;
}
