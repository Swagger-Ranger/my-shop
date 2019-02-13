package com.swaggerranger.my.shop.web.ui.controller;

import com.swaggerranger.my.shop.web.ui.api.ContentsApi;
import com.swaggerranger.my.shop.web.ui.dto.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
    public String index( Model model) {

        requestContentsPPT(model);

        return "index";
    }

    /**
     * @Description 请求幻灯片
     * @Param       model
     */
    private void requestContentsPPT( Model model ) {
        List<TbContent> tbContents = ContentsApi.ppt("89");
        for (TbContent tbContent : tbContents) {
            System.out.println(tbContents);
        }
        model.addAttribute("ppt", tbContents);
    }
}
