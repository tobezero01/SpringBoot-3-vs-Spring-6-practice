package com.luv2code.springboot.thymeleafcruddemo.dao;

import com.luv2code.springboot.thymeleafcruddemo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
