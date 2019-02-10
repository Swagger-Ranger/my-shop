package com.swaggerranger.my.shop.commons.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: HttpClientUtils
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/9 20:17
 * @Description: HttpClient工具类
 * @Aha-eureka:
 *******************************************************************************/

public class HttpClientUtils {

    public static final String GET = "get";
    public static final String POST = "post";
    public static final String REQUEST_HEADER_CONNECTION = "keep-alive";
    public static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36";

    /**
     * @Description Get请求
     * @Param       url请求地址
     * @return
     * @exception
     */
    public static String doGet(String url) {
        return createRequest(url, GET,null);
    }

    //重载带cookie的请求
    public static String doGet(String url,String cookie) {
        return createRequest(url, GET,cookie);
    }

    /**
     * @Description POST请求
     * @Param       url请求地址
     * @Param       params请求参数(可选)
     * @return
     * @exception
     */
    public static String doPost(String url,BasicNameValuePair... params) {
        return createRequest(url,POST,null,params);
    }

    //重载带cookie的请求
    public static String doPost(String url,String cookie,BasicNameValuePair... params) {
        return createRequest(url,POST,cookie,params);
    }

    /**
     * @Description
     * @Param      url地址
     * @Param      requestMethod请求方式
     * @Param      cookie
     * @return     params post请求带的参数
     * @exception   
     */
    private static String createRequest( String url, String requestMethod,String cookie, BasicNameValuePair... params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //请求方式
        HttpGet httpGet = null;
        HttpPost httpPost = null;

        //相应
        CloseableHttpResponse httpResponse = null;

        //请求结果
        String result = null;

        try {
            //GET请求
            if (GET.equals(requestMethod)) {
                httpGet = new HttpGet(url);

                httpGet.setHeader("Cookie",cookie);
                httpGet.setHeader("Connection", REQUEST_HEADER_CONNECTION);//长连接
                httpGet.setHeader("User-Agent",REQUEST_HEADER_USER_AGENT);  //用户代理，就是什么访问介质什么浏览器

                httpResponse = httpClient.execute(httpGet);
            }

            //POST请求
            else if (POST.equals(requestMethod)) {

                httpPost = new HttpPost(url);

                httpPost.setHeader("Cookie",cookie);
                httpPost.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                httpPost.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);


                //如果有传入参数
                if (params != null && params.length > 0) {
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params), "UTF-8"));
                }

                httpResponse = httpClient.execute(httpPost);
            }


            HttpEntity httpEntity = httpResponse.getEntity();

            result = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
