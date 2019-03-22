package com.mycompany.myapp.kiaf.log;

import lombok.Data;

/**
 * @author kedacom
 * @date 2018-11-19
 */
@Data
public class LogTempDTO {

    /**
     * LOG_TEMP序号
     */
    private Long logTempId;
    /**
     * 请求地址
     */
    private String requestUrl;
    /**
     * 请求方式
     */
    private String methodType;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 方法类名
     */
    private String classMethod;
    /**
     * 方法参数
     */
    private String methodArgs;
    /**
     * 参数压缩
     */
    private String zipArgs;

    /**
     * AccessLog 注解里的值
     */
    private String module;
}

