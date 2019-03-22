package com.mycompany.myapp.kiaf.entity;

import com.kedacom.kidp.base.data.common.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Created by keda on 2019/3/21.
 * 影院表
 */
@Entity
@Data
@Table(name = "cinema")
@EntityListeners(AuditingEntityListener.class)
public class Cinema extends BaseEntity{
    private String name;//影院名
    private String tel;//电话
    private String picture;//影院图片
    private String address;//地址
    private String district;//所在区
    private String longitude;//经度
    private String latitude;//纬度

}
