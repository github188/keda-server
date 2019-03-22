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
import java.util.Date;

/**
 * Created by keda on 2019/3/21.
 */
@Entity
@Data
@Table(name = "film")
@EntityListeners(AuditingEntityListener.class)
public class Film extends BaseEntity{
    @Column(name="up_time")
    private Date upTime;
    private String name;
   private String director;
   private String actor;
   @Column(name="picture_path")
   private String picturePath;
   @Column(name="file_path")
    private String filePath;
   private BigDecimal price;
   private String resume;
   private BigInteger views;
}
