package com.swaggerranger.my.shop.web.api.web.controller;

import com.swaggerranger.my.shop.domain.TbContent;
import com.swaggerranger.my.shop.web.api.service.TbContentService;
import com.swaggerranger.my.shop.web.api.web.dto.TbContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TbContentController
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/6 22:25
 * @Description:
 * @Aha-eureka: @RestController继承@Controller，所有的返回都是json格式，没有视图
 *******************************************************************************/

@RestController
@RequestMapping(value = "content")
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent( Long id ) {
        TbContent tbContent = null;

        if (id == null) {
            tbContent = new TbContent();
        }

        return tbContent;
    }

    /**
     * @Description 没有使用@ResponseBody注解来返回json，因为类的注解是@RestController
     * @Param
     * @return
     * @exception
     */
    @RequestMapping(value = "findContentByCategoryId",method = RequestMethod.GET)
    public List<TbContentDTO> findContentByCategoryId(Long categoryId ) {
        List<TbContentDTO> tbContentDTOS = null;
        List<TbContent> tbContents = tbContentService.selectByCategoryId(categoryId);

        if (tbContents != null && tbContents.size() > 0) {
            tbContentDTOS = new ArrayList<>();
            for (TbContent tbContent : tbContents) {
                TbContentDTO dto = new TbContentDTO();
                BeanUtils.copyProperties(tbContent,dto);
                tbContentDTOS.add(dto);
            }
        }
        return tbContentDTOS;
    }
}
