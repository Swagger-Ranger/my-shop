package com.swaggerranger.my.shop.web.admin.web.controller;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.domain.TbUser;
import com.swaggerranger.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * @return
     * @throws
     * @Description 跳转用户列表页
     * @Param
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list( Model model ) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }


    /**
     * @Description 这个用来从前端获取传入的参数，将多个参数绑定到一个tbUser对象，给页面显示使用
     * ModelAttribute详解：http://www.funtl.com/2018/06/16/monolithic/Spring-MVC-ModelAttribute-%E6%B3%A8%E8%A7%A3/
     * @Param
     * @return
     * @exception
     */
    @ModelAttribute
    public TbUser getTbUser( Long id ) {
        TbUser tbUser = null;
        //id不为空时，则从数据库获取
        if (id != null) {
            tbUser = tbUserService.getById(id);
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
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save( TbUser tbUser, Model model,RedirectAttributes redirectAttributes ) {
        BaseResult baseResult = tbUserService.save(tbUser);

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
     * @Description 搜索
     * @Param
     * @return
     * @exception
     */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search( TbUser tbUser ,Model model) {
        List<TbUser> tbUsers = tbUserService.search(tbUser);
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }


    /**
     * @Description 删除用户信息
     * @Param       ids
     * @return      String
     * @exception
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult delete( String ids ) {
        BaseResult baseResult = null;

        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            tbUserService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除成功");
        }

        else{
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }

}
