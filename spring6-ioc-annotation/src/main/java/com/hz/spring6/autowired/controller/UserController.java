package com.hz.spring6.autowired.controller;


import com.hz.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    public void run() {
        userService.run();
    }
}
