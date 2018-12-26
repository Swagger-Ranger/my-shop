package com.swaggerranger.my.shop.commons.dto;

import java.io.Serializable;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: BaseResult
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/22 17:03
 * @Description: 服务器验证信息自定义返回结果
 * @Aha-eureka:
 *******************************************************************************/

public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;
    private int status;
    private String message;

    public static BaseResult success() {
        return createResult(STATUS_SUCCESS, "成功");
    }

    public static BaseResult success( String message ) {
        return createResult(STATUS_SUCCESS, message);
    }

    public static BaseResult fail() {
        return createResult(STATUS_FAIL, "失败");
    }
    public static BaseResult fail(String message) {
        return createResult(STATUS_FAIL, message);
    }

    public static BaseResult fail( int status, String message ) {
        return createResult(status, message);
    }

    private static BaseResult createResult( int status, String message ) {
        BaseResult baseResult = new BaseResult();
        baseResult.setMessage(message);
        baseResult.setStatus(status);
        return baseResult;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus( int status ) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }
}
