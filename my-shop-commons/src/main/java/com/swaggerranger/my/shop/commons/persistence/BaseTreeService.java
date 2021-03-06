package com.swaggerranger.my.shop.commons.persistence;

import com.swaggerranger.my.shop.commons.dto.BaseResult;

import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: BaseTreeService
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/28 4:36
 * @Description: 树形结构服务类接口
 * @Aha-eureka:
 *******************************************************************************/

public interface BaseTreeService<T extends BaseEntity> {
    /**
     * @return
     * @throws
     * @Description 获取全部数据
     * @Param
     */
    List<T> selectAll();

    /**
     * @Description 新增数据
     * @Param
     * @return
     * @exception
     */
    BaseResult save( T entity );

    /**
     * @Description 根据id删除数据
     * @Param
     * @return
     * @exception
     */
    void delete( Long id );

    /**
     * @Description 根据id获取数据
     * @Param
     * @return
     * @exception
     */
    T getById( Long id );

    /**
     * @Description 更新数据
     * @Param
     * @return
     * @exception
     */
    void update( T entity );

    /**
     * @return
     * @throws
     * @Description 根据所有的父节点的子节点
     * @Param
     */
    List<T> selectByPid( Long pid );
}
