package com.zhaoya.hgshop.dao;

import java.util.List;

import com.zhaoya.hgshop.pojo.Category;


public interface CategoryDao {

	/**
	 * ���ݸ�id��ȡ�б�
	 * @param pid
	 * @return
	 */
	List<Category> listByParentId(int pid);

	int add(Category cat);

	int update(Category cat);

	int delete(int catId);
	

}
