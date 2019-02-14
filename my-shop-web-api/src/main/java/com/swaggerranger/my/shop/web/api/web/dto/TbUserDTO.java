package com.swaggerranger.my.shop.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbUserDTO
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/14 17:40
 * @Description: 会员登陆的数据传输对象、
 * @Aha-eureka:
 *******************************************************************************/
@Data
public class TbUserDTO implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String email;


}
