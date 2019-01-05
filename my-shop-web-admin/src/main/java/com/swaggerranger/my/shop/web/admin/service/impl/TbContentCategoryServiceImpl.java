package com.swaggerranger.my.shop.web.admin.service.impl;

import com.swaggerranger.my.shop.domain.TbContentCategory;
import com.swaggerranger.my.shop.web.admin.dao.TbContentCategoryDao;
import com.swaggerranger.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentCategoryServiceImpl
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/3 23:29
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }
}
