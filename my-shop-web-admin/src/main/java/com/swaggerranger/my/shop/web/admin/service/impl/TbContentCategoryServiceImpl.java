package com.swaggerranger.my.shop.web.admin.service.impl;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.domain.TbContentCategory;
import com.swaggerranger.my.shop.web.admin.dao.TbContentCategoryDao;
import com.swaggerranger.my.shop.web.admin.service.TbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentCategoryServiceImpl
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/3 23:29
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

    @Override
    public List<TbContentCategory> selectByPid( Long pid ) {
        return tbContentCategoryDao.selectByPid(pid);
    }

    @Override
    public BaseResult save( TbContentCategory tbContentCategory ) {
        BaseResult baseResult = checkTbContentCategory(tbContentCategory);

        //通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbContentCategory.setUpdated(new Date());


            //新增
            if (tbContentCategory.getId() == null) {
                tbContentCategory.setCreated(new Date());
                tbContentCategoryDao.insert(tbContentCategory);
            }

            //编辑
            else {
                tbContentCategoryDao.update(tbContentCategory);
            }

            baseResult.setMessage("保存用户信息成功");
        }

        return baseResult;
    }

    /**
     * @Description 有效性验证
     * @Param
     * @return
     * @exception
     */
    private BaseResult checkTbContentCategory( TbContentCategory tbContentCategory ) {
        BaseResult baseResult = BaseResult.success();

        if (tbContentCategory.getParentId() == null) {
            baseResult = BaseResult.fail("父级类目不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbContentCategory.getName())) {
            baseResult = BaseResult.fail("分类名不能为空，请重新输入");
        } else if (tbContentCategory.getSortOrder() == null) {
            baseResult = BaseResult.fail("内容排序数值不能为空，请重新输入");
        }
        return baseResult;
    }

}
