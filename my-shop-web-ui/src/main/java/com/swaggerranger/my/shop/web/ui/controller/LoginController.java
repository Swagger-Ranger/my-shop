package com.swaggerranger.my.shop.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: LoginController
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/13 15:23
 * @Description: 前端登陆
 * @Aha-eureka:
 *******************************************************************************/
@Controller
public class LoginController {

    @RequestMapping(value = "signIn",method = RequestMethod.GET)
    public String signIn() {
        return "dengl";
    }


    @RequestMapping(value = "singUp",method = RequestMethod.GET)
    public String signUp() {
        return "zhuc";
    }

}
