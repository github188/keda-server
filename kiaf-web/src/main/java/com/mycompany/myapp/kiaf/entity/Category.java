package com.mycompany.myapp.kiaf.entity;

import com.kedacom.kidp.base.data.common.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Created by keda on 2019/3/21.
 * 影片分类表
 */
@Entity
@Data
@Table(name = "category")
@EntityListeners(AuditingEntityListener.class)
public class Category extends BaseEntity{
    private String name;//分类名称
}
