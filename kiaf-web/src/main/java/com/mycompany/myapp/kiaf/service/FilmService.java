package com.mycompany.myapp.kiaf.service;

import com.mycompany.myapp.kiaf.entity.Film;

/**
 * Created by keda on 2019/3/21.
 */
public interface FilmService {
    Film findById(Long id);
    Film save(Film film);
}
