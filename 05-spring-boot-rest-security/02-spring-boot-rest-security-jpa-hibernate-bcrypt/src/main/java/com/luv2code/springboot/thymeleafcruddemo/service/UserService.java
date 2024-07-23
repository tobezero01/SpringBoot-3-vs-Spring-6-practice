package com.luv2code.springboot.thymeleafcruddemo.service;

import com.luv2code.springboot.thymeleafcruddemo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

}
