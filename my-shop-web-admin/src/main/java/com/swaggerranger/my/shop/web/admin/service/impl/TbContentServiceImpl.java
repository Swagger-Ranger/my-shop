package com.swaggerranger.my.shop.web.admin.service.impl;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.validator.BeanValidator;
import com.swaggerranger.my.shop.domain.TbContent;
import com.swaggerranger.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.swaggerranger.my.shop.web.admin.dao.TbContentDao;
import com.swaggerranger.my.shop.web.admin.service.TbContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentServiceImpl
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/6 0:13
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent,TbContentDao> implements TbContentService {

    @Override
    @Transactional(readOnly = false)
    public BaseResult save( TbContent tbContent ) {

        String validator = BeanValidator.validator(tbContent);

        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            tbContent.setUpdated(new Date());


            //新增
            if (tbContent.getId() == null) {
                tbContent.setCreated(new Date());
                dao.insert(tbContent);
            }

            //编辑用户
            else {
                update(tbContent);
            }

            return BaseResult.success("保存用户信息成功");
        }

    }




}
