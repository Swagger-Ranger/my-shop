package com.swaggerranger.my.shop.web.admin.service;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.dto.PageInfo;
import com.swaggerranger.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService {

    /**
     * @Description 查询全部
     * @Param
     * @return
     * @exception
     */
    List<TbUser> selectAll();

    /**
     * @Description 保存用户信息
     * @Param
     * @return
     * @exception
     */
    BaseResult save( TbUser tbUser );

    /**
     * @Description 删除用户信息
     * @Param
     * @return
     * @exception
     */
    void delete( Long id );

    /**
     * @Description 根据id获取用户信息
     * @Param
     * @return
     * @exception
     */
    TbUser getById( Long id );

    /**
     * @Description 更新用户信息
     * @Param
     * @return
     * @exception
     */
    void update( TbUser tbUser );

    /**
     * @Description 登陆
     * @Param
     * @return
     * @exception
     */
    TbUser login( String email, String password );

    /**
     * @Description 批量删除
     * @Param
     * @return
     * @exception
     */
    void deleteMulti( String[] ids );

    /**
     * @return
     * @throws
     * @Description 分页查询
     * @Param
     */
    PageInfo<TbUser> page( int draw, int start, int length ,TbUser tbUser);

    /**
     * @Description 分页显示的总数查询
     * @Param
     * @return
     * @exception
     */
    int count(TbUser tbUser);
}
