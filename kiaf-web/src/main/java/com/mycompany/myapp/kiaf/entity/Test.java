package com.mycompany.myapp.kiaf.entity;

import javax.persistence.*;
import java.util.*;
import lombok.*;
import java.math.BigDecimal;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.kedacom.kidp.base.data.common.entity.BaseEntity;


/**
* Created by kedacom on 2019-03-15.
* 
*/
@Entity
@Data
@Table(name = "test")
@EntityListeners(AuditingEntityListener.class)
public class Test  extends BaseEntity  {
     @Basic
     private String testcol;
}
