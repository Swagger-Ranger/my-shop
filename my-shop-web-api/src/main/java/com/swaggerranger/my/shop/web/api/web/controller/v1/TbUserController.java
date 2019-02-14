package com.swaggerranger.my.shop.web.api.web.controller.v1;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.domain.TbUser;
import com.swaggerranger.my.shop.web.api.service.TbUserService;
import com.swaggerranger.my.shop.web.api.web.dto.TbUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbUserController
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/13 16:34
 * @Description: 会员管理
 * @Aha-eureka:
 *******************************************************************************/
@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult signIn( TbUser tbUser ) {
        TbUser user = tbUserService.signIn(tbUser);
        if (user == null) {
            return BaseResult.fail("账号或密码错误");
        } else {
            TbUserDTO dto = new TbUserDTO();
            BeanUtils.copyProperties(user, dto);
            return BaseResult.success("登陆成功", dto);
        }
    }
}
