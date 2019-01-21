package com.swaggerranger.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: UploadController
 * @Author: liufei32@outlook.com
 * @Date: 2019/1/19 0:33
 * @Description: 文件上传控制器
 * @Aha-eureka:
 *******************************************************************************/

@Controller
public class UploadController {

    private static final String UPLOAD_PATH = "/static/upload/";

    /**
     * @return
     * @throws
     * @Description 文件上传
     * @Param
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload( MultipartFile dropFile, HttpServletRequest request ) {

        Map<String, Object> result = new HashMap<>();

        //文件名
        String fileName = dropFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        //存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);

        File file = new File(filePath);
        //判断路径是否存在，不存在则创建文件夹
        if (!file.exists()) file.mkdir();

        file = new File(filePath, UUID.randomUUID() + fileSuffix);

        try {
            dropFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        result.put("fileName", UPLOAD_PATH + file.getName());

        return result;
    }
}
