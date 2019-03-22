package com.mycompany.myapp.kiaf.service.impl;

import com.mycompany.myapp.kiaf.dao.FilmDao;
import com.mycompany.myapp.kiaf.entity.Film;
import com.mycompany.myapp.kiaf.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by keda on 2019/3/21.
 */
@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmDao filmDao;
    @Override
    public Film findById(Long id) {
        return filmDao.getOne(id);
    }
    public Film save(Film film){
       return  filmDao.save(film);
    }
}
