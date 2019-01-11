package com.swaggerranger.my.shop.domain;

import com.swaggerranger.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContent
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/6 0:03
 * @Description: 内容管理
 * @Aha-eureka:
 *******************************************************************************/
@Data
public class TbContent extends BaseEntity {
    private Long categoryId;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;

}
