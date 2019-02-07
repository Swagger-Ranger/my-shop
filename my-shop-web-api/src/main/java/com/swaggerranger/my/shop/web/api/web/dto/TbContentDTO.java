package com.swaggerranger.my.shop.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentDTO
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/7 19:29
 * @Description: 内容数据传输对象
 * @Aha-eureka:
 *******************************************************************************/

@Data
public class TbContentDTO implements Serializable {

    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
