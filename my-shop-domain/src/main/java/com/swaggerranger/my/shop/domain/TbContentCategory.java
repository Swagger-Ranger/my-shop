package com.swaggerranger.my.shop.domain;

import com.swaggerranger.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentCategory
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/3 23:20
 * @Description: 分类管理
 * @Aha-eureka:
 *******************************************************************************/
@Data
public class TbContentCategory extends BaseEntity {

    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Boolean isParent;
}
