package com.swaggerranger.my.shop.domain;

import com.swaggerranger.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

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

    @NotNull(message = "父级类目不能为空")
    private Long categoryId;

    @Length(min = 1,max = 20,message = "标题长度介于1-20个字符之间")
    private String title;
    @Length(min = 1,max = 50,message = "子标题长度介于1-50个字符之间")
    private String subTitle;

    @Length(min = 1,max = 50,message = "标题描述长度介于1-50个字符之间")
    private String titleDesc;

    private String url;
    private String pic;
    private String pic2;

    @Length(min = 1,message = "请输入内容")
    private String content;

}
