package com.mycompany.myapp.kiaf.entity;

import com.kedacom.kidp.base.data.common.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by keda on 2019/3/21.
 * 影片影院连接表
 */
@Entity
@Data
@Table(name = "film_cinema")
@EntityListeners(AuditingEntityListener.class)
public class FilmCinema extends BaseEntity {
    @Column(name = "film_id")
    private Long filmId;
    @Column(name = "cinema_id")
    private Long cinemaId;
    @Column(name = "up_time")
    private Date upTime;
    @Column(name = "down_time")
    private Date downTime;
}
