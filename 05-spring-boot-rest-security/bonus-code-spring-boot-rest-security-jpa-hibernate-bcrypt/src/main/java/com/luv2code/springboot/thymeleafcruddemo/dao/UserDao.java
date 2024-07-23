package com.luv2code.springboot.thymeleafcruddemo.dao;

import com.luv2code.springboot.thymeleafcruddemo.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
}
