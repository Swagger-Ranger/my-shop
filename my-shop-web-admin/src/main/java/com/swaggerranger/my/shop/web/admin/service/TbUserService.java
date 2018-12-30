package com.swaggerranger.my.shop.web.admin.service;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.dto.PageInfo;
import com.swaggerranger.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService {
    List<TbUser> selectAll();

    BaseResult save( TbUser tbUser );

    void delete( Long id );

    TbUser getById( Long id );

    void update( TbUser tbUser );

    List<TbUser> selectByUsername( String username );

    TbUser login( String email, String password );


    List<TbUser> search(TbUser tbUser);

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
    PageInfo<TbUser> page( int draw, int start, int length );

    int count();
}
