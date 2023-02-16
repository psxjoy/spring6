package com.hz.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    private Logger log = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
        user.add();
    }

    @Test
    public void testObject() throws Exception {
        Class<?> clazz = Class.forName("com.hz.spring6.user");
        clazz.newInstance();
        clazz.getDeclaredConstructor().newInstance();
    }
    //loading properties
}
