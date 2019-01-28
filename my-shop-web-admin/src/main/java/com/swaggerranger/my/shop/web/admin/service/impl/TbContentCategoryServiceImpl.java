package com.swaggerranger.my.shop.web.admin.service.impl;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.validator.BeanValidator;
import com.swaggerranger.my.shop.domain.TbContentCategory;
import com.swaggerranger.my.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import com.swaggerranger.my.shop.web.admin.dao.TbContentCategoryDao;
import com.swaggerranger.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.stereotype.Service;
import java.util.Date;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentCategoryServiceImpl
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/3 23:29
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

@Service
public class TbContentCategoryServiceImpl extends AbstractBaseTreeServiceImpl<TbContentCategory,TbContentCategoryDao> implements TbContentCategoryService {

    @Override
    public BaseResult save( TbContentCategory entity ) {

        String validator = BeanValidator.validator(entity);

        if (validator != null) {
            return BaseResult.fail(validator);
        }

        else {
            TbContentCategory parent = entity.getParent();

            //没有选择父节点则默认设置为根目录:0
            if (parent == null || parent.getId() == null) {
                parent.setId(0L);
                entity.setIsParent(true);

            }

            entity.setUpdated(new Date());

            //新增
            if (entity.getId() == null) {
                entity.setCreated(new Date());
                entity.setIsParent(false);

                //判断当前节点有没有父节点
                if (parent.getId() != 0L) {
                    TbContentCategory currentCategoryParent = getById(parent.getId());
                    if (currentCategoryParent != null) {
                        //将父节点的isParent设置为true
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);

                    }
                }

                //父节点为0，表示为根节点
                else{
                    entity.setIsParent(true);
                }

                dao.insert(entity);
            }


            //修改
            else {
                update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }

}
