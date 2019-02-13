package com.swaggerranger.my.shop.web.api.service;

import com.swaggerranger.my.shop.domain.TbUser;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbUserService
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/13 16:21
 * @Description: 会员管理
 * @Aha-eureka:
 *******************************************************************************/


public interface TbUserService {

    /**
     * @Description 登陆
     * @Param       tbUser
     * @return
     * @exception
     */
    TbUser signIn( TbUser tbUser );
}
