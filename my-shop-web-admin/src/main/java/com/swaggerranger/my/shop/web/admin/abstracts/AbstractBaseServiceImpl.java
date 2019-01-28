package com.swaggerranger.my.shop.web.admin.abstracts;

import com.swaggerranger.my.shop.commons.dto.PageInfo;
import com.swaggerranger.my.shop.commons.persistence.BaseDao;
import com.swaggerranger.my.shop.commons.persistence.BaseEntity;
import com.swaggerranger.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: AbstractBaseServiceImpl
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/29 1:48
 * @Description: service层的抽象类的封装代码
 * @Aha-eureka:
 *******************************************************************************/

public abstract class AbstractBaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    protected D dao;

    /**
     * @return
     * @throws
     * @Description 查询全部
     * @Param
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * @return
     * @throws
     * @Description 删除信息
     * @Param
     */
    @Override
    public void delete( Long id ) {
        dao.delete(id);
    }

    /**
     * @return
     * @throws
     * @Description 根据id获取信息
     * @Param
     */
    @Override
    public T getById( Long id ) {
        return dao.getById(id);
    }

    /**
     * @return
     * @throws
     * @Description 更新信息
     * @Param
     */
    @Override
    public void update( T entity ) {
        dao.update(entity);
    }

    /**
     * @return
     * @throws
     * @Description 批量删除
     * @Param
     */
    @Override
    public void deleteMulti( String[] ids ) {
        dao.deleteMulti(ids);
    }

    /**
     * @return
     * @throws
     * @Description 分页显示的总数查询
     * @Param
     */
    @Override
    public int count( T entity ) {
        return dao.count(entity);
    }

    /**
     * @Description 分页查询
     * @Param
     * @return
     * @exception
     */
    @Override
    public PageInfo<T> page( int draw, int start, int length , T entity) {
        //封装dataTable需要地结果，详细的解释建注释的文档:http://www.datatables.club/manual/server-side.html
        int count = count(entity);
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(dao.page(params));

        return pageInfo;
    }
}
