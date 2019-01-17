package com.swaggerranger.my.shop.web.admin.service.impl;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.dto.PageInfo;
import com.swaggerranger.my.shop.commons.utils.RegExpUtils;
import com.swaggerranger.my.shop.commons.validator.BeanValidator;
import com.swaggerranger.my.shop.domain.TbUser;
import com.swaggerranger.my.shop.web.admin.dao.TbUserDao;
import com.swaggerranger.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                tbUserDao.insert(tbUser);
            }

            //编辑用户
            else {
                tbUserDao.update(tbUser);
            }

            return BaseResult.success("保存用户信息成功");
        }
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
    public void deleteMulti( String[] ids ) {
        tbUserDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbUser> page( int draw, int start, int length ,TbUser tbUser) {

        //封装dataTable需要地结果，详细的解释建注释的文档:http://www.datatables.club/manual/server-side.html
        int count = tbUserDao.count(tbUser);
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("tbUser", tbUser);

        PageInfo<TbUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbUserDao.page(params));

        return pageInfo;
    }

    @Override
    public int count(TbUser tbUser) {
        return tbUserDao.count(tbUser);
    }

}
