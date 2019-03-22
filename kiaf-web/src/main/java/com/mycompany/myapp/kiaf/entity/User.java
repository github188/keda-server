package com.mycompany.myapp.kiaf.entity;

import com.kedacom.kidp.base.data.common.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by keda on 2019/3/19.
 * 用户表
 */
@Entity
@Data
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity{
    private String name;
    private String email;
    private String password;
    @Column(name = "pic_path")
    private String picPath;//图片路径
    private BigDecimal balance;//余额
}
