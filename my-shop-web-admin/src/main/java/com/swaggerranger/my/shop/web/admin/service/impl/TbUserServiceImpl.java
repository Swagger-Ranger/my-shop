package com.swaggerranger.my.shop.web.admin.service.impl;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.utils.RegExpUtils;
import com.swaggerranger.my.shop.domain.TbUser;
import com.swaggerranger.my.shop.web.admin.dao.TbUserDao;
import com.swaggerranger.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: TbUserServiceImpl
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/18 15:23
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public BaseResult save( TbUser tbUser ) {
        BaseResult baseResult = checkTbUser(tbUser);

        //通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbUser.setUpdated(new Date());


            //新增用户
            if (tbUser.getId() == null) {
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));//密码加密
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }

            //编辑用户
            else {
                tbUserDao.update(tbUser);
            }

            baseResult.setMessage("保存用户信息成功");
        }

        return baseResult;
    }

    @Override
    public void delete( Long id ) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById( Long id ) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update( TbUser tbUser ) {
        tbUserDao.update(tbUser);
    }

    @Override
    public List<TbUser> selectByUsername( String username ) {
        return tbUserDao.selectByUsername(username);
    }

    @Override
    public TbUser login( String email, String password ) {
        TbUser tbUser = tbUserDao.getByEmail(email);

        if (tbUser != null) {
            //明文密码加密后判断是否于数据库中存放的一致
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

    @Override
    public List<TbUser> search(TbUser tbUser) {
        /*TbUser tbUser = new TbUser();
        tbUser.setUsername(keyword);
        tbUser.setEmail(keyword);
        tbUser.setPhone(keyword);*/
        return tbUserDao.search(tbUser);
    }

    /**
     * @Description 用户的有效性验证
     * @Param
     * @return
     * @exception
     */
    private BaseResult checkTbUser( TbUser tbUser ) {
        BaseResult baseResult = BaseResult.success();

        if (StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空，请重新输入");
        } else if (!RegExpUtils.checkEmail(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
        } else if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("姓名不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号不能为空，请重新输入");
        } else if (!RegExpUtils.checkPhone(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号格式不正确，请重新输入");
        }

        return baseResult;
    }
}
