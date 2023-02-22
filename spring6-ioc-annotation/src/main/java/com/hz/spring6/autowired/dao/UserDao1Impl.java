package com.hz.spring6.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "userDao1Impl")
public class UserDao1Impl implements UserDao{
    @Override
    public void run() {
        System.out.println("dao1 run");
    }
}
