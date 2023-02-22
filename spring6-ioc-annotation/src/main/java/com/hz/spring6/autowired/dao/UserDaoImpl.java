package com.hz.spring6.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl  implements UserDao{
    @Override
    public void run() {
        System.out.println("dao run");
    }
}
