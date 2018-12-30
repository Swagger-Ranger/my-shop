package com.swaggerranger.my.shop.commons.persistence;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: BaseEntity
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/30 18:05
 * @Description: 实体类地基类
 * @Aha-eureka:
 *******************************************************************************/

public abstract class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated( Date created ) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated( Date updated ) {
        this.updated = updated;
    }
}
