package com.hz.spring6.iocxml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {


    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        //根据 id 获取Bean
        User user = (User) ctx.getBean("user1");
        System.out.println(user);
        //根据类型获取bean
        User user1 = ctx.getBean(User.class);
        System.out.println(user1);
        //根据id 和类型
        User user2 = ctx.getBean("user", User.class);
        System.out.println(user2);

    }
}
