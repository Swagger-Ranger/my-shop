package com.swaggerranger.my.shop.web.admin.service;

import com.swaggerranger.my.shop.commons.persistence.BaseService;
import com.swaggerranger.my.shop.domain.TbUser;

public interface TbUserService extends BaseService<TbUser> {

    /**
     * @return
     * @throws
     * @Description 登陆
     * @Param
     */
    TbUser login( String email, String password );
}
