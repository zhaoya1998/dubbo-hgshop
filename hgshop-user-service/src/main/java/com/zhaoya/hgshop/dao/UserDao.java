package com.zhaoya.hgshop.dao;

import com.zhaoya.hgshop.pojo.User;

public interface UserDao {

	int add(User user);

	User findUser(User user);

	/**
	 * 根据用户名查找
	 * @param name
	 * @return
	 */
	User findByUsername(String name);

}
