package com.zhaoya.hgshop.dao;

import com.zhaoya.hgshop.pojo.User;

public interface UserDao {

	int add(User user);

	User findUser(User user);

	/**
	 * �����û�������
	 * @param name
	 * @return
	 */
	User findByUsername(String name);

}
