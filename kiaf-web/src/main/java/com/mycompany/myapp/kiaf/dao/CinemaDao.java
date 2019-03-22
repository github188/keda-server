package com.mycompany.myapp.kiaf.dao;

import com.mycompany.myapp.kiaf.entity.Cinema;
import feign.Param;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by keda on 2019/3/22.
 */
public interface CinemaDao extends JpaRepository<Cinema,Long> {
    @Query(value = "select c from Cinema c where c.district = ?1 ")
    List<Cinema> findByDistrict(@Param("district") String district);
}
