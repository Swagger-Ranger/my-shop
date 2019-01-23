package com.swaggerranger.my.shop.web.admin.dao;

import com.swaggerranger.my.shop.commons.persistence.BaseDao;
import com.swaggerranger.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbUserDao extends BaseDao<TbUser> {

    /**
     * @Description 根据邮箱查询用户
     * @Param
     * @return
     * @exception
     */
    TbUser getByEmail( String email );
}
