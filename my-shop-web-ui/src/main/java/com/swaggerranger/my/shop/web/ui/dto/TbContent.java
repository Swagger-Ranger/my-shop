package com.swaggerranger.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContent
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/11 20:07
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
@Data
public class TbContent implements Serializable {

    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
