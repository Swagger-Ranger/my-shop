package com.swaggerranger.my.shop.web.ui.interceptor;

import com.swaggerranger.my.shop.web.ui.constant.SystemConstants;
import com.swaggerranger.my.shop.web.ui.dto.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: LoginInterceptor
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/15 1:14
 * @Description: 登陆拦截器
 * @Aha-eureka:
 *******************************************************************************/

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        TbUser tbUsers = (TbUser) request.getSession().getAttribute(SystemConstants.SESSION_USER_KEY);
        //未登录状态
        if (tbUsers == null) {
            return true;
        }

        //已登录状态
        else{
            response.sendRedirect("/index");
            return false;
        }
    }

    @Override
    public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) throws Exception {

    }

    @Override
    public void afterCompletion( HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex ) throws Exception {

    }
}
