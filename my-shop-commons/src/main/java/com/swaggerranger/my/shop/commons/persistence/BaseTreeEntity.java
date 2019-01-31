package com.swaggerranger.my.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: BaseTreeEntity
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/31 15:09
 * @Description: 树形实体类接口
 * @Aha-eureka:
 *******************************************************************************/
@Data
public abstract class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    protected T parent;
    protected Boolean isParent;
}
