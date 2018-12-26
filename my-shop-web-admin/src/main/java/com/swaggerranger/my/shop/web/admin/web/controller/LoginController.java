package com.swaggerranger.my.shop.web.admin.web.controller;

import com.swaggerranger.my.shop.commons.constant.ConstantUtils;
import com.swaggerranger.my.shop.domain.TbUser;
import com.swaggerranger.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: LoginController
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/16 14:55
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
@Controller
public class LoginController {

    //@Autowired自动装配器，就是不用MVC注解的UserService userService = SpringContext.getBean("userService")
    @Autowired
    private TbUserService tbUserService;

    private final String COOKIE_NAME = "userInfo";

    /**
     * RequestMapping的value就是浏览器请求的路径可以有多个，""就是默认路径localhost:8080/，"login"就是localhost:8080/login
     *
     * @return java.lang.String
     * @throws
     * @Description 跳转登陆页
     * @Param []
     */
/*    @RequestMapping(value = {"","login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest httpServletRequest) {
        String userInfo = CookieUtils.getCookieValue(httpServletRequest, COOKIE_NAME);
        if (!StringUtils.isBlank(userInfo)) {
            String[] userInfoArray = userInfo.split(":");
            String email = userInfoArray[0];
            String password = userInfoArray[1];
            httpServletRequest.setAttribute("email",email);
            httpServletRequest.setAttribute("password",password);
            httpServletRequest.setAttribute("isRemember", true);

        }
        return "login";
    }*/
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    /**
     * RequestParam(required=true)就是必须带这个参数才能请求这个方法，false即不必带参也能请求
     *
     * @return
     * @throws
     * @Description 登陆逻辑
     * @Param
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login( @RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model ) {
        TbUser tbUser = tbUserService.login(email,password);

        //登陆失败
        if (tbUser == null) {
            model.addAttribute("message", "用户码或密码错误请重新输入");
            return login();
        }

        //登陆成功
        else {
            //将登陆信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "redirect:/main";
        }

    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout( HttpServletRequest httpServletRequest ) {
        httpServletRequest.getSession().invalidate();
        return login();
    }


}
