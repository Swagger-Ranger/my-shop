package com.swaggerranger.my.shop.web.admin.web.controller;

import com.swaggerranger.my.shop.domain.TbContentCategory;
import com.swaggerranger.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ContentCategoryController
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/3 23:31
 * @Description: 内容分类管理
 * @Aha-eureka:
 *******************************************************************************/

@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {

    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list( Model model ) {
        List<TbContentCategory> sourceContentCategories = tbContentCategoryService.selectAll();
        List<TbContentCategory> targetContentCategories = new ArrayList<>();
        sortList(sourceContentCategories, targetContentCategories, 0L);
        model.addAttribute("tbContentCategories", targetContentCategories);
        return "content_category_list";

    }

    @RequestMapping(value = "tree/data", method = RequestMethod.POST)
    @ResponseBody
    public List<TbContentCategory> treeData( Long id ) {
        if (id == null) {
            id = 0L;
        }
        return tbContentCategoryService.selectByPid(id);
    }


    /**
     * @Description 将查询出的数据作排序，来供treeTable使用，目的就是子节点的要紧接着夫节点之后
     * @Param       sourceList:源数据，targetList：排序后数据
     * @return
     * @exception
     */
    private void sortList( List<TbContentCategory> sourceList, List<TbContentCategory> targetList, Long parentId ) {
        for (TbContentCategory contentCategory : sourceList) {
            if (contentCategory.getParentId().equals(parentId)) {
                targetList.add(contentCategory);

                if (contentCategory.getIsParent()) {
                    for (TbContentCategory contentCategory1 : sourceList) {
                        if (contentCategory1.getParentId().equals(contentCategory.getId())) {
                            sortList(sourceList,targetList,contentCategory.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
