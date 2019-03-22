package com.mycompany.myapp.kiaf.dao;

import com.mycompany.myapp.kiaf.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by keda on 2019/3/21.
 */
public interface FilmDao extends JpaRepository<Film,Long> {
}
