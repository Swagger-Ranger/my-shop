package com.swaggerranger.my.shop.web.admin.service;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.persistence.BaseService;
import com.swaggerranger.my.shop.domain.TbContentCategory;

import java.util.List;

public interface TbContentCategoryService extends BaseService<TbContentCategory> {

    /**
     * @Description 根据所有的父节点的子节点
     * @Param
     * @return
     * @exception
     */
    List<TbContentCategory> selectByPid(Long pid);
}
