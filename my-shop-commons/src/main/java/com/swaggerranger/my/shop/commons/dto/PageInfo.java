package com.swaggerranger.my.shop.commons.dto;

import com.swaggerranger.my.shop.commons.persistence.BaseEntity;

import java.io.Serializable;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: PageInfo
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/30 17:49
 * @Description: 前端分页数据传输对象
 * @Aha-eureka:
 *******************************************************************************/

public class PageInfo<T extends BaseEntity> implements Serializable {

    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw( int draw ) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal( int recordsTotal ) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered( int recordsFiltered ) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData( List<T> data ) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError( String error ) {
        this.error = error;
    }


}
