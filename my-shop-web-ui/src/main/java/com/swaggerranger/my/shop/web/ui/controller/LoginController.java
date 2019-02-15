package com.swaggerranger.my.shop.web.ui.controller;

import com.google.code.kaptcha.Constants;
import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.web.ui.constant.SystemConstants;
import com.swaggerranger.my.shop.web.ui.api.UsersApi;
import com.swaggerranger.my.shop.web.ui.dto.TbUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: LoginController
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/13 15:23
 * @Description: 前端登陆
 * @Aha-eureka:
 *******************************************************************************/
@Controller
public class LoginController {

/*
    @RequestMapping(value = "signIn",method = RequestMethod.GET)
    public String signIn() {
        return "signIn";
    }
*/

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public String signIn( TbUser tbUser, Model model, HttpServletRequest request ) throws Exception {

        //验证码验证
        if (!checkVerification(tbUser, request)) {
            model.addAttribute("baseResult", BaseResult.fail("验证码错误，请重新输入"));
            return "signIn";
        }


        TbUser user = UsersApi.login(tbUser);

        //登陆失败
        if (user == null) {
            model.addAttribute("baseResult", BaseResult.fail("登陆失败，请检查用户名或密码"));
            return "signIn";
        }
        //登陆成功
        else {
            request.getSession().setAttribute(SystemConstants.SESSION_USER_KEY, user);
            return "redirect:/index";
        }
    }

    @RequestMapping(value = "signOut", method = RequestMethod.GET)
    public String signOut( HttpServletRequest request ) {
        request.getSession().invalidate();
        return "redirect:/index";
    }

    @RequestMapping(value = "signUp",method = RequestMethod.GET)
    public String signUp() {
        return "signUp";
    }


    /**
     * @return
     * @throws
     * @Description 验证码检查
     * @Param
     */
    private boolean checkVerification( TbUser user, HttpServletRequest request ) {
        String verification = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (StringUtils.equals(verification, user.getVerification())) {
            return true;
        } else {
            return false;
        }
    }
}
