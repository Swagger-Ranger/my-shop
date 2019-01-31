package com.swaggerranger.my.shop.domain;

import com.swaggerranger.my.shop.commons.persistence.BaseTreeEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentCategory
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/3 23:20
 * @Description: 分类管理
 * @Aha-eureka:
 *******************************************************************************/
@Data
public class TbContentCategory extends BaseTreeEntity {

    private TbContentCategory parent;

    @Length(min=1,max = 20,message="分类名称必须介于1-20之间")
    private String name;
    private Integer status;

    @NotNull(message = "排序数值不能为空")
    private Integer sortOrder;
    private Boolean isParent;
}
