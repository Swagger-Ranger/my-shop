package com.swaggerranger.my.shop.web.admin.dao;

import com.swaggerranger.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao {
    List<TbContentCategory> selectAll();

    /**
     * @Description 根据所有的父节点的子节点
     * @Param
     * @return
     * @exception
     */
    List<TbContentCategory> selectByPid(Long pid);
}
