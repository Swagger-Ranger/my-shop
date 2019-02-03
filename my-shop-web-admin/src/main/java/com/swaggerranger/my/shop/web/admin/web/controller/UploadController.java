package com.swaggerranger.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    public Map<String, Object> upload( MultipartFile dropFile, MultipartFile[] editorFiles, HttpServletRequest request ) {

        Map<String, Object> result = new HashMap<>();

        //前端上传的文件
//        MultipartFile myFile = dropFile == null ? editorFile : dropFile;

        //dropZone的上传
        if (dropFile != null) {
            result.put("fileName", writeFile(dropFile,request));//返回给图片上传后显示的路径,即内部路径/static/upload/66398e55-f4a4-415f-b9c3-342ab955650c.jpg

        }
        //wangEditor的上传
        if (editorFiles != null && editorFiles.length > 0) {

            /**
             * 富文本编辑器的图片上传功能
             * scheme:服务器提供的协议 http/https
             * serverName:服务器名称 localhost/ip/domain
             * serverPath：服务器端口
             */

            List<String> fileNames = new ArrayList<>();
            for (MultipartFile editorFile : editorFiles) {
                fileNames.add(writeFile(editorFile, request));
            }
            result.put("errno", 0);
            result.put("data", fileNames);//显示在富文本编辑器里的图片地址，即网络地址
        }

        return result;
    }

    /**
     * @Description 返回文件的完整路径
     * @Param
     * @return
     * @exception
     */
    private String writeFile( MultipartFile multipartFile, HttpServletRequest request ) {
        //文件名
        String fileName = multipartFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        //存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);

        File file = new File(filePath);
        //判断路径是否存在，不存在则创建文件夹
        if (!file.exists()) file.mkdir();

        file = new File(filePath, UUID.randomUUID() + fileSuffix);

        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return serverPath + UPLOAD_PATH + file.getName();
    }
}
