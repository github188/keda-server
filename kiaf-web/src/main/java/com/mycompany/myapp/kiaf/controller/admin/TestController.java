package com.mycompany.myapp.kiaf.controller.admin;

import com.kedacom.ctsp.web.controller.message.ResponseMessage;
import com.kedacom.kidp.base.web.controller.BaseCrudController;
import com.mycompany.myapp.kiaf.entity.Test;
import com.mycompany.myapp.kiaf.vo.TestSearchVO;
import com.mycompany.myapp.kiaf.vo.TestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/test")
public class TestController extends BaseCrudController<Test, TestVO, TestSearchVO> {

    @GetMapping("/test")
    public ResponseMessage queryTest() {
        return ResponseMessage.ok("test api");
    }
}
