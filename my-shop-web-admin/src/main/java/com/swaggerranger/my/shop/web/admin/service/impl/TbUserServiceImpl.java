package com.swaggerranger.my.shop.web.admin.service.impl;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.validator.BeanValidator;
import com.swaggerranger.my.shop.domain.TbUser;
import com.swaggerranger.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.swaggerranger.my.shop.web.admin.dao.TbUserDao;
import com.swaggerranger.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: TbUserServiceImpl
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/18 15:23
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
@Service
@Transactional(readOnly = true)
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser,TbUserDao> implements TbUserService {


    @Override
    @Transactional(readOnly = false)
    public BaseResult save( TbUser tbUser ) {
        String validator = BeanValidator.validator(tbUser);

        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //验证通过
        else {

            tbUser.setUpdated(new Date());


            //新增用户
            if (tbUser.getId() == null) {
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));//密码加密
                tbUser.setCreated(new Date());
                dao.insert(tbUser);
            }

            //编辑用户
            else {
                update(tbUser);
            }

            return BaseResult.success("保存用户信息成功");
        }
    }

    @Override
    public TbUser login( String email, String password ) {
        TbUser tbUser = dao.getByEmail(email);

        if (tbUser != null) {
            //明文密码加密后判断是否于数据库中存放的一致
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }





}
