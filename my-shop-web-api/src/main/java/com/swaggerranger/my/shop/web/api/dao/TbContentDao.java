package com.swaggerranger.my.shop.web.api.dao;

import com.swaggerranger.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentDao
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/6 21:54
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
@Repository
public interface TbContentDao {

    /**
     * @Description 根据类别id查询内容列表
     * @Param
     * @return
     * @exception
     */
    List<TbContent> selectByCategoryId( TbContent tbContent );
}
