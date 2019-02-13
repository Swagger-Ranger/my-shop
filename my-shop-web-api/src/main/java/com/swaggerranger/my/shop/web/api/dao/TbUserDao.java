package com.swaggerranger.my.shop.web.api.dao;

import com.swaggerranger.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbUserDao
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/13 16:06
 * @Description: api 会员管理
 * @Aha-eureka:
 *******************************************************************************/
@Repository
public interface TbUserDao {

    TbUser signIn(TbUser tbUser);
}
