package com.mycompany.myapp.kiaf.service.impl;

import com.mycompany.myapp.kiaf.entity.*;
import com.mycompany.myapp.kiaf.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kedacom.kidp.base.data.common.service.impl.BaseServiceImpl;


/**
* Created by kedacom on 2019-03-15.
*/
@Service
@Transactional
public class TestServiceImpl  extends BaseServiceImpl<Test>  implements TestService {
}
