package com.swaggerranger.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swaggerranger.my.shop.commons.persistence.BaseEntity;
import com.swaggerranger.my.shop.commons.utils.RegExpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: TbUser
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/18 14:53
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
@Data
public class TbUser extends BaseEntity {
    @Length(min=6,max = 20,message = "姓名长度请介于6-20位之间")
    private String username;

    @JsonIgnore
    @Length(min=6,max = 20,message = "密码长度必须介于6-20位之间")
    private String password;

    @Pattern(regexp = RegExpUtils.PHONE,message = "手机号格式不正确")
    private String phone;

    @Pattern(regexp = RegExpUtils.EMAIL,message = "邮箱格式不正确")
    private String email;

}
