package com.zhaoya.hgshop.service;

import java.util.List;

import com.zhaoya.hgshop.pojo.Category;

public interface CategoryService {

	// ��
	List<Category> getTree();
	//��
	int add(Category cat);
		
	//�޸�
	int update(Category cat);
		
	//ɾ��
	int delete(int catId);
	
	
	

}
