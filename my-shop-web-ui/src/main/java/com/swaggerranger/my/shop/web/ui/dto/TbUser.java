package com.swaggerranger.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbUser
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/14 0:38
 * @Description: 与api对接的数据传输对象
 * @Aha-eureka:
 *******************************************************************************/
@Data
public class TbUser implements Serializable {

    private Long id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String verification;

}
