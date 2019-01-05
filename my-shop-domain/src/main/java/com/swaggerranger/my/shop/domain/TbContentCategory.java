package com.swaggerranger.my.shop.domain;

import com.swaggerranger.my.shop.commons.persistence.BaseEntity;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentCategory
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/3 23:20
 * @Description: 分类管理
 * @Aha-eureka:
 *******************************************************************************/

public class TbContentCategory extends BaseEntity {

    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Boolean isParent;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId( Long parentId ) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder( Integer sortOrder ) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent( Boolean isParent ) {
        this.isParent = isParent;
    }
}
