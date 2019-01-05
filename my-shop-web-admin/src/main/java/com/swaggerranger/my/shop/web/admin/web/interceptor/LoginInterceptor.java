package com.swaggerranger.my.shop.web.admin.web.interceptor;

import com.swaggerranger.my.shop.commons.constant.ConstantUtils;
import com.swaggerranger.my.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: LoginInterceptor
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/16 15:26
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o ) throws Exception {
        TbUser user = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

        //未登录
        if (user == null) {
            httpServletResponse.sendRedirect("/login");
        }

        //前置拦截，返回false就是失败被拦截，true则放行,只要这里放行就会去执行postHandle
        return true;
    }

    public void postHandle( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView ) throws Exception {

    }

    public void afterCompletion( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e ) throws Exception {

    }
}
