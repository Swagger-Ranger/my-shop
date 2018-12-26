package com.swaggerranger.my.shop.domain;

import java.io.Serializable;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: User
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/16 14:41
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class User implements Serializable {
    private String email;
    private String password;
    private String username;
    private boolean isRemember;//页面登陆记住我标识

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public boolean isRemember() {
        return isRemember;
    }

    public void setRemember( boolean remember ) {
        isRemember = remember;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", isRemember=" + isRemember +
                '}';
    }
}
