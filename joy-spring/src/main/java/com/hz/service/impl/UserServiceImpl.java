package com.hz.service.impl;

import com.hz.anno.Bean;
import com.hz.anno.Di;
import com.hz.dao.UserDao;
import com.hz.service.UserService;

@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;
}
