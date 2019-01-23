package com.swaggerranger.my.shop.commons.persistence;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.dto.PageInfo;

import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: BaseService
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/23 23:25
 * @Description: 所有业务逻辑层的基类
 * @Aha-eureka:
 *******************************************************************************/

public interface BaseService<T extends BaseEntity> {

    /**
     * @Description 查询全部
     * @Param
     * @return
     * @exception
     */
    List<T> selectAll();

    /**
     * @Description 保存信息
     * @Param
     * @return
     * @exception
     */
    BaseResult save( T entity );

    /**
     * @Description 删除信息
     * @Param
     * @return
     * @exception
     */
    void delete( Long id );

    /**
     * @Description 根据id获取信息
     * @Param
     * @return
     * @exception
     */
    T getById( Long id );

    /**
     * @Description 更新信息
     * @Param
     * @return
     * @exception
     */
    void update( T entity );

    /**
     * @Description 批量删除
     * @Param
     * @return
     * @exception
     */
    void deleteMulti( String[] ids );

    /**
     * @return
     * @throws
     * @Description 分页查询
     * @Param
     */
    PageInfo<T> page( int draw, int start, int length, T entity );

    /**
     * @Description 分页显示的总数查询
     * @Param
     * @return
     * @exception
     */
    int count(T entity);
}
