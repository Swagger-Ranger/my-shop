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
    public Map<String, Object> upload( MultipartFile dropFile, MultipartFile editorFile, HttpServletRequest request ) {

        Map<String, Object> result = new HashMap<>();

        //前端上传的文件
        MultipartFile myFile = dropFile == null ? editorFile : dropFile;


        //文件名
        String fileName = myFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        //存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);

        File file = new File(filePath);
        //判断路径是否存在，不存在则创建文件夹
        if (!file.exists()) file.mkdir();

        file = new File(filePath, UUID.randomUUID() + fileSuffix);

        try {
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //dropZone的返回
        if (dropFile != null) {
            result.put("fileName", UPLOAD_PATH + file.getName());//返回给图片上传后显示的路径,即内部路径/static/upload/66398e55-f4a4-415f-b9c3-342ab955650c.jpg

        }
        //富文本编辑器的返回
        else {
            /**
             * 富文本编辑器的图片上传功能
             * scheme:服务器提供的协议 http/https
             * serverName:服务器名称 localhost/ip/domain
             * serverPath：服务器端口
             */
            String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
            result.put("errno", 0);
            result.put("data", new String[]{serverPath + UPLOAD_PATH + file.getName()});//显示在富文本编辑器里的图片地址，即网络地址
        }

        return result;
    }
}
