package com.swaggerranger.my.shop.web.ui.api;

import com.swaggerranger.my.shop.commons.utils.HttpClientUtils;
import com.swaggerranger.my.shop.commons.utils.MapperUtils;
import com.swaggerranger.my.shop.web.ui.dto.TbContent;

import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ContentsApi
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/11 21:52
 * @Description: 内容管理接口
 * @Aha-eureka:
 *******************************************************************************/

public class ContentsApi {

    public static List<TbContent> ppt( String id ) {

        String result = HttpClientUtils.doGet(API.API_CONTENTS + id);


        List<TbContent> tbContents = null;
        try {
            tbContents = MapperUtils.json2listByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return tbContents;
    }
}
