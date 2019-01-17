package com.swaggerranger.my.shop.web.admin.service.impl;

import com.swaggerranger.my.shop.commons.dto.BaseResult;
import com.swaggerranger.my.shop.commons.dto.PageInfo;
import com.swaggerranger.my.shop.commons.validator.BeanValidator;
import com.swaggerranger.my.shop.domain.TbContent;
import com.swaggerranger.my.shop.web.admin.dao.TbContentDao;
import com.swaggerranger.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentServiceImpl
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/6 0:13
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

    @Override
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
                tbContentDao.insert(tbContent);
            }

            //编辑用户
            else {
                tbContentDao.update(tbContent);
            }

            return BaseResult.success("保存用户信息成功");
        }

    }

    @Override
    public void delete( Long id ) {
        tbContentDao.delete(id);
    }

    @Override
    public TbContent getById( long id ) {
        return tbContentDao.getById(id);
    }

    @Override
    public void update( TbContent tbContent ) {
        tbContentDao.update(tbContent);
    }

    @Override
    public void deleteMulti( String[] ids ) {
        tbContentDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbContent> page( int draw, int start, int length ,TbContent tbContent) {
        //封装dataTable需要地结果，详细的解释建注释的文档:http://www.datatables.club/manual/server-side.html
        int count = tbContentDao.count(tbContent);
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("tbContent", tbContent);

        PageInfo<TbContent> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbContentDao.page(params));

        return pageInfo;
    }

    @Override
    public int count( TbContent tbContent ) {
        return tbContentDao.count(tbContent);
    }

}
