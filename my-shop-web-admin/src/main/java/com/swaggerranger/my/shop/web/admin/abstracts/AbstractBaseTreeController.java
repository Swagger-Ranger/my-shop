package com.swaggerranger.my.shop.web.admin.abstracts;

import com.swaggerranger.my.shop.commons.dto.PageInfo;
import com.swaggerranger.my.shop.commons.persistence.BaseEntity;
import com.swaggerranger.my.shop.commons.persistence.BaseTreeEntity;
import com.swaggerranger.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: AbstractBaseTreeController
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/31 14:53
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public abstract class AbstractBaseTreeController<T extends BaseTreeEntity, S extends BaseTreeService<T>> {

    @Autowired
    protected S service;

    /**
     * @Description 列表页
     */
    public abstract String list( Model model );

    /**
     * @Description 提交表单
     */
    public abstract String form( T entity );

    /**
     * @Description 保存
     */
    public abstract String save( T entity, Model model, RedirectAttributes redirectAttributes );

    /**
     * @Description 树形结构
     */
    public abstract List<T> treeData( Long id );

    /**
     * @Description 这个树形控制器不需要分页
     */
    public PageInfo page( HttpServletRequest request,BaseEntity entity ) {
        return null;
    }

    /**
     * @Description 将查询出的数据作排序，来供treeTable使用，目的就是子节点的要紧接着夫节点之后
     * @Param       sourceList:源数据，targetList：排序后数据
     * @return
     * @exception
     */
    protected void sortList( List<T> sourceList, List<T> targetList, Long parentId ) {
        for (T sourceEntity: sourceList) {
            if (sourceEntity.getParent().getId().equals(parentId)) {
                targetList.add(sourceEntity);

                if (sourceEntity.getIsParent()) {
                    for (T currentEntity : sourceList) {
                        if (currentEntity.getParent().getId().equals(sourceEntity.getId())) {
                            sortList(sourceList,targetList,sourceEntity.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
