package com.swaggerranger.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swaggerranger.my.shop.commons.persistence.BaseEntity;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: TbUser
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/18 14:53
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class TbUser extends BaseEntity {
    private String username;
    private String password;
    private String phone;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

}
