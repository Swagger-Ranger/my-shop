package com.swaggerranger.my.shop.web.api.service;

import com.swaggerranger.my.shop.domain.TbContent;

import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentService
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/6 22:14
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public interface TbContentService {

    /**
     * @return
     * @throws
     * @Description 根据类别id查询内容列表
     * @Param
     */
    List<TbContent> selectByCategoryId( Long categoryId );
}
