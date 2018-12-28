package com.swaggerranger.my.shop.web.admin.dao;

import com.swaggerranger.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserDao {

    /**
     * @return
     * @throws
     * @Description 获取全部用户信息
     * @Param
     */
    List<TbUser> selectAll();

    /**
     * @Description 新增用户
     * @Param
     * @return
     * @exception
     */
    void insert( TbUser tbUser );

    /**
     * @Description 根据id删除用户
     * @Param
     * @return
     * @exception
     */
    void delete( Long id );

    /**
     * @Description 根据id获取单个用户
     * @Param
     * @return
     * @exception
     */
    TbUser getById( long id );

    /**
     * @Description 更新用户
     * @Param
     * @return
     * @exception
     */
    void update( TbUser tbUser );

    /**
     * @Description 根据用户名模糊查找
     * @Param
     * @return
     * @exception
     */
    List<TbUser> selectByUsername( String username );

    /**
     * @Description 根据邮箱查询用户
     * @Param
     * @return
     * @exception
     */
    TbUser getByEmail( String email );

    /**
     * @Description 搜索用户
     * @Param
     * @return
     * @exception
     */
    List<TbUser> search( TbUser tbUser );

    /**
     * @Description 批量删除
     * @Param       String[] ids
     * @return      void
     */
    void deleteMulti( String[] ids );
}
