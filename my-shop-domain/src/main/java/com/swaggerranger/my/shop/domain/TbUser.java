package com.swaggerranger.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swaggerranger.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: TbUser
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/18 14:53
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
@Data
public class TbUser extends BaseEntity {
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String email;

}
