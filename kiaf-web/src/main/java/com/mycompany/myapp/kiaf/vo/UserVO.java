package com.mycompany.myapp.kiaf.vo;

import com.kedacom.kidp.base.data.common.IdAware;
import com.kedacom.kidp.base.data.common.dto.SearchDTO;
import com.kedacom.kidp.base.data.common.query.AnnotatedSpecificationQuerySupport;
import com.mycompany.myapp.kiaf.entity.User;
import lombok.Data;

/**
 * Created by keda on 2019/3/21.
 */
@Data
public class UserVO extends SearchDTO implements IdAware<Long>, AnnotatedSpecificationQuerySupport<User> {
    private Long Id;
    private String name;
    private String email;
    private String password;
    private String picPath;//图片路径
    private String balance;//余额

}
