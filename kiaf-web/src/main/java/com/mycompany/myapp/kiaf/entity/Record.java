package com.mycompany.myapp.kiaf.entity;

import com.kedacom.kidp.base.data.common.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.math.BigInteger;

/**
 * Created by keda on 2019/3/21.
 * 用户浏览记录表
 */
@Entity
@Data
@Table(name = "record")
@EntityListeners(AuditingEntityListener.class)
public class Record extends BaseEntity{
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "film_id")
    private Long filmId;
}
