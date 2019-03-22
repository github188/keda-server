package com.mycompany.myapp.kiaf.vo;

import com.kedacom.kidp.base.data.common.IdAware;
import com.kedacom.kidp.base.data.common.dto.SearchDTO;
import com.kedacom.kidp.base.data.common.query.AnnotatedSpecificationQuerySupport;
import com.mycompany.myapp.kiaf.entity.Bill;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by keda on 2019/3/21.
 */
@Data
public class BillVO extends SearchDTO implements IdAware<Long>, AnnotatedSpecificationQuerySupport<Bill> {
    private Long id;
    private BigInteger userId;
    private BigDecimal money;
    private String content;
    private int type;

}
