package com.swaggerranger.my.shop.web.ui.api;

import com.swaggerranger.my.shop.commons.utils.HttpClientUtils;
import com.swaggerranger.my.shop.commons.utils.MapperUtils;
import com.swaggerranger.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: UsersApi
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/14 0:35
 * @Description: 会员管理接口
 * @Aha-eureka:
 *******************************************************************************/

public class UsersApi {

    /*public static BaseResult login( TbUser tbUser ) {
        List<BasicNameValuePair> pararms = new ArrayList<>();
        pararms.add(new BasicNameValuePair("username", tbUser.getUsername()));
        pararms.add(new BasicNameValuePair("password", tbUser.getPassword()));

        //pararms.toArray(new BasicNameValuePair[pararms.size()]因为toarray需要传入一个带泛型参数且指定大小的数组
        String resultJson = HttpClientUtils.doPost(API.API_USERS_LOGIN, pararms.toArray(new BasicNameValuePair[pararms.size()]));
        System.out.println(resultJson);

        return null;

    }*/

    public static TbUser login( TbUser tbUser ) throws Exception {
        List<BasicNameValuePair> pararms = new ArrayList<>();
        pararms.add(new BasicNameValuePair("username", tbUser.getUsername()));
        pararms.add(new BasicNameValuePair("password", tbUser.getPassword()));

        //pararms.toArray(new BasicNameValuePair[pararms.size()]因为toarray需要传入一个带泛型参数且指定大小的数组
        String resultJson = HttpClientUtils.doPost(API.API_USERS_LOGIN, pararms.toArray(new BasicNameValuePair[pararms.size()]));

        TbUser user = MapperUtils.json2pojoByTree(resultJson, "data", TbUser.class);

        return user;

    }

}
