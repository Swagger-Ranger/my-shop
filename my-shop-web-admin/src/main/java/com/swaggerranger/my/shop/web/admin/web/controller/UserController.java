package com.swaggerranger.my.shop.web.admin.web.controller;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.domain.TbUser;
import com.swaggerranger.my.shop.web.admin.abstracts.AbstractBaseController;
import com.swaggerranger.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: UserController
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/22 0:55
 * @Description: 用户管理
 * @Aha-eureka:
 *******************************************************************************/

@Controller
@RequestMapping(value = "user")
public class UserController extends AbstractBaseController<TbUser,TbUserService> {


    /**
     * @return
     * @throws
     * @Description 跳转用户列表页,这里只是跳转页面，页面数据则在页面中ajax请求的数据然后封装pageInfo做分页显示
     * @Param
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user_list";
    }


    /**
     * @Description 这个用来从前端获取传入的参数，将多个参数绑定到一个tbUser对象，给页面显示使用,
     *      就是user_list.jsp中会请求var showDetailUrl = "/user/detail?id=" + row.id;然后@ModelAttribute注解会在所有controller方法之前执行，这里就是将id查询出来并封装成对象，然后给/user/detail使用
     * ModelAttribute详解：http://www.funtl.com/2018/06/16/monolithic/Spring-MVC-ModelAttribute-%E6%B3%A8%E8%A7%A3/
     * @Param
     * @return
     * @exception
     */
    @ModelAttribute
    public TbUser getTbUser( Long id ) {
        TbUser tbUser;
        //id不为空时，则从数据库获取
        if (id != null) {
            tbUser = service.getById(id);
        }

        else{
            tbUser = new TbUser();
        }
        return tbUser;
    }


    /**
     * @return
     * @throws
     * @Description 跳转用户表单页
     * @Param
     */
    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }

    /**
     * @Description 保存用户信息,使用RedirectAttributes来保存跳转的属性，因为一旦重定向，request里的信息就会丢失，session也可以存
     *              但会存过长时间消耗不必要的内存
     * @Param
     * @return
     * @exception
     */
    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save( TbUser tbUser, Model model,RedirectAttributes redirectAttributes ) {
        BaseResult baseResult = service.save(tbUser);

        //传入用户信息验证成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);//重定向之后就失效
            return "redirect:/user/list";
        }
        //传入用户信息验证失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "user_form";
        }

    }

    /**
     * @Description 删除用户信息
     * @Param       ids
     * @return      String
     * @exception
     */
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult delete( String ids ) {
        BaseResult baseResult = null;

        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除成功");
        }

        else{
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }


    /**
     * @Description 前端传入一个id，所有的@ResposeBody 都会先经过@ModelAttribute来将传入的参数封装成对象，所有这里传入的就是一个TbUser
     * @Param
     * @return
     * @exception
     */
    @Override
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail( TbUser tbUser ) {
        return "user_detail";
    }
}
