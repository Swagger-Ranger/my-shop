package com.swaggerranger.my.shop.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IndexController
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/9 14:24
 * @Description: 视图层，首页contoller
 * @Aha-eureka:
 *******************************************************************************/

@Controller
public class IndexController {

    /**
     * @Description 跳转首页
     * @Param
     * @return      
     * @exception   
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
