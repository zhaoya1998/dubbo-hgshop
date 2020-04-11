package com.zhaoya.hgshop.dao;

import java.util.List;

import com.zhaoya.hgshop.pojo.Category;


public interface CategoryDao {

	/**
	 * 根据父id获取列表
	 * @param pid
	 * @return
	 */
	List<Category> listByParentId(int pid);

	int add(Category cat);

	int update(Category cat);

	int delete(int catId);
	

}
