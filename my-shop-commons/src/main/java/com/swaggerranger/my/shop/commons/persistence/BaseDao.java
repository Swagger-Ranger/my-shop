package com.swaggerranger.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: BaseDao
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/23 23:11
 * @Description: 所有数据访问层的基类
 * @Aha-eureka:
 *******************************************************************************/

public interface BaseDao<T> {
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
    void insert( T entity );

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
     * @Description 批量删除
     * @Param       String[] ids
     * @return      void
     */
    void deleteMulti( String[] ids );

    /**
     * @return      List<T>
     * @throws
     * @Description 分页查询
     * @Param params:需要两个参数：数据开始位置start和每页数据条数length
     */
    List<T> page( Map<String, Object> params );

    /**
     * @Description 查询数据库总数据数量
     * @Param
     * @return
     * @exception
     */
    int count( T entity );

}
