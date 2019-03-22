package com.mycompany.myapp.kiaf.service.impl;

import com.mycompany.myapp.kiaf.dao.CinemaDao;
import com.mycompany.myapp.kiaf.entity.Cinema;
import com.mycompany.myapp.kiaf.service.CinemaService;
import com.mycompany.myapp.kiaf.utils.VOUtils;
import com.mycompany.myapp.kiaf.vo.CinemaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keda on 2019/3/22.
 */
@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CinemaDao cinemaDao;

    @Override
    public List<CinemaVO> findAllByDistrict(String district) {
        List<Cinema> cinemas = cinemaDao.findByDistrict(district);
        List<CinemaVO> cinemaVOS = new ArrayList<>();
        cinemas.stream().forEach(cinema ->{
            CinemaVO cinemaVO = new CinemaVO();
            cinemaVO = (CinemaVO)VOUtils.populate(cinema,cinemaVO);
            cinemaVOS.add(cinemaVO);
        });
        return cinemaVOS;

    }

    @Override
    public CinemaVO findDetail(Long id) {
        Cinema cinema=cinemaDao.getOne(id);
        CinemaVO cinemaVO = new CinemaVO();
        cinemaVO = (CinemaVO)VOUtils.populate(cinema,cinemaVO);
        return  cinemaVO;
    }
}
