package com.swaggerranger.my.shop.web.api.service.impl;

import com.swaggerranger.my.shop.domain.TbUser;
import com.swaggerranger.my.shop.web.api.dao.TbUserDao;
import com.swaggerranger.my.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbUserServiceImpl
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/13 16:23
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao dao;


    @Override
    public TbUser signIn( TbUser tbUser ) {

        TbUser user = dao.signIn(tbUser);
        if (user != null) {
            String password = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
            if (password.equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }
}
