package com.swaggerranger.my.shop.commons.utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: EmailSendUtils
 * @Author: liufei32@outlook.com
 * @Date: 2019/2/16 23:46
 * @Description: 邮件发送工具类
 * @Aha-eureka:
 *******************************************************************************/

public class EmailSendUtils {


    @Autowired
    private Email email;

    public void sendEmail(String subject,String msg,String... to) throws EmailException {
//        Email email = new SimpleEmail();
//        email.setHostName("smtp.qq.com");
//        email.setSmtpPort(465);
//        email.setAuthenticator(new DefaultAuthenticator("674939506@qq.com", "glcxieopjmkjbceh"));
//        email.setSSLOnConnect(true);
//        email.setFrom("674939506@qq.com");
        email.setSubject(subject);
        email.setMsg(msg);
        email.addTo(to);
        email.send();
    }

}
