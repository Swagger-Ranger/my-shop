package com.swaggerranger.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: MainController
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/16 14:55
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
@Controller
public class MainController {

    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main() {
        return "main";
    }
}
