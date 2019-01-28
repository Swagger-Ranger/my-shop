package com.swaggerranger.my.shop.web.admin.abstracts;

import com.swaggerranger.my.shop.commons.persistence.BaseEntity;
import com.swaggerranger.my.shop.commons.persistence.BaseTreeDao;
import com.swaggerranger.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: AbstractBaseTreeServiceImpl
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/28 4:51
 * @Description: 树形结构的抽象类以进一步封装代码
 * @Aha-eureka:
 *******************************************************************************/

public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity, D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    @Autowired
    protected D dao;

    /**
     * @Description 获取全部数据
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }



    /**
     * @Description 根据id删除数据
     * @Param
     * @return
     * @exception
     */
    @Override
    public void delete( Long id ) {
        dao.delete(id);
    }

    /**
     * @Description 根据id获取数据
     * @Param
     * @return
     * @exception
     */
    @Override
    public T getById( Long id ) {
        return dao.getById(id);
    }

    /**
     * @Description 更新数据
     * @Param
     * @return
     * @exception
     */
    @Override
    public void update( T entity ) {
        dao.update(entity);
    }

    /**
     * @return
     * @throws
     * @Description 根据所有的父节点的子节点
     * @Param
     */
    @Override
    public List<T> selectByPid( Long pid ) {
        return dao.selectByPid(pid);
    }

}
