package com.mycompany.myapp.kiaf.vo;

import com.kedacom.kidp.base.data.common.IdAware;
import com.kedacom.kidp.base.data.common.dto.SearchDTO;
import com.kedacom.kidp.base.data.common.query.AnnotatedSpecificationQuerySupport;
import com.mycompany.myapp.kiaf.entity.Test;
import lombok.Data;

@Data
public class TestSearchVO extends SearchDTO implements IdAware<Long>, AnnotatedSpecificationQuerySupport<Test> {
    private Long id;
    private String testcol;

}
