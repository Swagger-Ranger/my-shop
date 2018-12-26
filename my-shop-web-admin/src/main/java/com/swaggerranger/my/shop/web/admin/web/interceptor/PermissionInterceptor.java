package com.swaggerranger.my.shop.web.admin.web.interceptor;

import com.swaggerranger.my.shop.commons.constant.ConstantUtils;
import com.swaggerranger.my.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: PermissionInterceptor
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/16 15:28
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class PermissionInterceptor implements HandlerInterceptor {
    public boolean preHandle( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o ) throws Exception {
        return true;
    }

    public void postHandle( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView ) throws Exception {
        //以login的请求结尾
        if (modelAndView.getViewName().endsWith("login")) {
            TbUser user = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if (user != null) {
                httpServletResponse.sendRedirect("/main");
            }
        }

    }

    public void afterCompletion( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e ) throws Exception {

    }
}
