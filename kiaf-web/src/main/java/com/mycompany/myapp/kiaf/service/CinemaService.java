package com.mycompany.myapp.kiaf.service;

import com.mycompany.myapp.kiaf.entity.Cinema;
import com.mycompany.myapp.kiaf.vo.CinemaVO;

import java.util.List;

/**
 * Created by keda on 2019/3/22.
 */
public interface CinemaService {
    List<CinemaVO> findAllByDistrict(String district);
    CinemaVO findDetail(Long id);
}
