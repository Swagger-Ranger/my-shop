package com.swaggerranger.my.shop.web.admin.dao;

import com.swaggerranger.my.shop.commons.persistence.BaseDao;
import com.swaggerranger.my.shop.domain.TbContent;
import com.swaggerranger.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao extends BaseDao<TbContentCategory> {
    /**
     * @return
     * @throws
     * @Description 根据所有的父节点的子节点
     * @Param
     */
    List<TbContentCategory> selectByPid( Long pid );
}
