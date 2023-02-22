package com.hz.spring6.autowired.service;

import com.hz.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void run() {
        userDao.run();
        System.out.println("service run");
    }
}
