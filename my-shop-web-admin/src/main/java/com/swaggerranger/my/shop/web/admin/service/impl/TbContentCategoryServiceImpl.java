package com.swaggerranger.my.shop.web.admin.service.impl;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.dto.PageInfo;
import com.swaggerranger.my.shop.commons.validator.BeanValidator;
import com.swaggerranger.my.shop.domain.TbContentCategory;
import com.swaggerranger.my.shop.web.admin.dao.TbContentCategoryDao;
import com.swaggerranger.my.shop.web.admin.service.TbContentCategoryService;
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

                tbContentCategoryDao.insert(entity);
            }


            //修改
            else {
                tbContentCategoryDao.update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }

    @Override
    public void delete( Long id ) {

    }

    @Override
    public TbContentCategory getById( Long id ) {
        return tbContentCategoryDao.getById(id);
    }

    @Override
    public void update( TbContentCategory entity ) {
        tbContentCategoryDao.update(entity);
    }

    @Override
    public void deleteMulti( String[] ids ) {

    }

    @Override
    public PageInfo<TbContentCategory> page( int draw, int start, int length, TbContentCategory entity ) {
        return null;
    }

    @Override
    public int count( TbContentCategory entity ) {
        return 0;
    }

}
