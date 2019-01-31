package com.swaggerranger.my.shop.web.admin.abstracts;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.dto.PageInfo;
import com.swaggerranger.my.shop.commons.persistence.BaseEntity;
import com.swaggerranger.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: AbstractBaseController
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/31 11:35
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public abstract class AbstractBaseController<T extends BaseEntity,S extends BaseService> {

    @Autowired
    protected S service;//注入业务逻辑层

    /**
     * @Description 从架构上规定必须有一个跳转列表的方法
     */
    public abstract String list();

    /**
     * @Description 跳转表单页
     */
    public abstract String form();

    /**
     * @Description 信息保存
     */
    public abstract String save( T entity, Model model, RedirectAttributes redirectAttributes );

    /**
     * @Description 删除
     */
    public abstract BaseResult delete( String ids );

    /**
     * @Description 分页
     */
    public abstract PageInfo<T> page( HttpServletRequest request, T entity );

    /**
     * @Description 跳转详情
     */
    public abstract String detail( T entity );
}
