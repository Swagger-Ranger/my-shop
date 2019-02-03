package com.swaggerranger.my.shop.web.admin.abstracts;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.dto.PageInfo;
import com.swaggerranger.my.shop.commons.persistence.BaseEntity;
import com.swaggerranger.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * @Description 分页查询的后台处理,框架dataTable请求后台：http://www.datatables.club/manual/server-side.html
     * @Param
     * @return
     * @exception
     */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<T> page( HttpServletRequest request, T entity ) {
        //处理传参
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strDraw == null ? 0 : Integer.parseInt(strStart);
        int length = strDraw == null ? 10 : Integer.parseInt(strLength);

        //封装dataTable需要地结果，详细的解释建注释的文档
        PageInfo<T> pageInfo = service.page(draw, start, length, entity);

        return pageInfo;
    }

    /**
     * @Description 跳转详情
     */
    public abstract String detail( T entity );
}
