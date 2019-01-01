package com.swaggerranger.my.shop.web.admin.service.test;

import com.swaggerranger.my.shop.domain.TbUser;
import com.swaggerranger.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2018,github:Swagger-Ranger 
 * @FileName: TbUserServiceTest
 * @Author: liufei32@outlook.com
 * @Date: 2018/12/18 15:44
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/
/**
 * @Description 这里在配置ContextConfiguration时classpath指定的路径就是my-shop-web-admin-1.0.0-SNAPSHOT部署的包下的classes
 * @Param
 * @return
 * @exception
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        tbUsers.forEach(s-> System.out.println(s.getUsername()));
    }

    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setCreated(new Date());
        tbUser.setEmail("liufei32@outlook.com");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUser.setPhone("18381657954");
        tbUser.setUsername("Swagger-Ranger");
        tbUser.setUpdated(new Date());

        tbUserService.save(tbUser);
    }

    @Test
    public void testDelete() {
        tbUserService.delete(38L);
    }

    @Test
    public void testGetById() {
        TbUser tbUser = tbUserService.getById(12L);
        System.out.println(tbUser.getUsername());
    }

    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserService.getById(12l);
        tbUser.setUsername("swar");
        tbUser.setUpdated(new Date());
        tbUserService.update(tbUser);
    }

}
