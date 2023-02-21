package com.hz.spring6.iocxml.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {

    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = ctx.getBean(UserDao.class);

    }
}
