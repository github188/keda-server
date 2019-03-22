package com.mycompany.myapp.kiaf.vo;

import com.kedacom.kidp.base.data.common.IdAware;
import com.kedacom.kidp.base.data.common.dto.SearchDTO;
import com.kedacom.kidp.base.data.common.query.AnnotatedSpecificationQuerySupport;
import com.mycompany.myapp.kiaf.entity.Cinema;
import lombok.Data;

/**
 * Created by keda on 2019/3/22.
 */
@Data
public class CinemaVO extends SearchDTO implements IdAware<Long>, AnnotatedSpecificationQuerySupport<Cinema> {
    private Long id;
    private String name;//影院名
    private String tel;//电话
    private String picture;//影院图片
    private String address;//地址
    private String district;//所在区
    private String longitude;//经度
    private String latitude;//纬度
}
