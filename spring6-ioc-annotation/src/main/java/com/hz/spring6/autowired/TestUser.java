package com.hz.spring6.autowired;

import com.hz.spring6.autowired.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        UserController userController = ctx.getBean(UserController.class);
        userController.run();
    }
}
