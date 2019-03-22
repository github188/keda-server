package com.mycompany.myapp.kiaf.handler;


import com.alibaba.fastjson.JSONException;
import com.kedacom.ctsp.web.controller.message.ResponseMessage;
import com.kedacom.kidp.base.web.exception.ServiceException;
import com.kedacom.kidp.base.web.support.ResponseGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author kedacom
 * @date 2018-11-16
 */

@ControllerAdvice
@Slf4j
@Order(kiafExceptionHandler.Order.GLOBAL_PRECEDENCE)
public class kiafExceptionHandler {


    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseMessage handleServiceException(ServiceException be) {

        log.error(be.getMsg(),be);
        return ResponseGenerator.genFailResult("服务异常"+be.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseMessage handleIllegalParamException(MethodArgumentNotValidException e) { // 处理方法参数的异常类型
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        StringBuilder tips = new StringBuilder("参数不合法: ");
        if (errors.size() > 0) {
            for (ObjectError error : errors) {
                tips.append(error.getDefaultMessage()).append("; ");
            }
            //去掉最后一个 ;
            tips.deleteCharAt(tips.length() - 1);
        }

        return ResponseGenerator.genFailResult(tips);
    }


    @ExceptionHandler(JSONException.class)
    @ResponseBody
    public ResponseMessage handleJSONException(JSONException be) {
        log.error(be.getMessage(), be);
        return ResponseGenerator.genFailResult("字符串必须是JSON格式。");
    }


    @ExceptionHandler(ObjectOptimisticLockingFailureException.class)
    @ResponseBody
    public ResponseMessage handleVersionException(ObjectOptimisticLockingFailureException oplfe) {
        log.error(oplfe.getMessage(), oplfe);
        return ResponseGenerator.genFailResult("数据已被更改过，请更新数据后再修改。");
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseMessage exceptionHandle(Throwable e) {

        String errorMsg = "java.util.LinkedHashMap cannot be cast to com.kedacom.ctsp.web.controller.message.ResponseMessage";
        log.error(e.getMessage(), e);
        // 前端调用后端一个不存在的 Restful 接口时，会抛下面的错误信息
        if (errorMsg.equals(e.getMessage())) {
            return ResponseGenerator.genFailResult("访问的接口不存在。");
        }
        return ResponseGenerator.genFailResult("服务器内部错误");
    }

    public interface Order {
        int GLOBAL_PRECEDENCE=Ordered.LOWEST_PRECEDENCE-11000;
    }
}
