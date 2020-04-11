package com.zhaoya.hgshop.service;

import java.util.List;

import com.zhaoya.hgshop.pojo.Category;

public interface CategoryService {

	// ²é
	List<Category> getTree();
	//Ôö
	int add(Category cat);
		
	//ÐÞ¸Ä
	int update(Category cat);
		
	//É¾³ý
	int delete(int catId);
	
	
	

}
