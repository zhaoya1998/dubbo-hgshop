package com.zhaoya.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhaoya.hgshop.dao.CategoryDao;
import com.zhaoya.hgshop.pojo.Category;
import com.zhaoya.hgshop.service.CategoryService;

/**
 * 分类管理
 * @author zhuzg
 *
 */
@Service(interfaceClass=CategoryService.class)
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDao catDao;
	

	@Override
	public List<Category> getTree() {
		// TODO Auto-generated method stub
		return catDao.listByParentId(0);
		
	}


	@Override
	public int add(Category cat) {
		// TODO Auto-generated method stub
		return catDao.add(cat);
	}


	@Override
	public int update(Category cat) {
		// TODO Auto-generated method stub
		return catDao.update(cat);
	}


	@Override
	public int delete(int catId) {
		// TODO Auto-generated method stub
		return catDao.delete(catId);
	}

}
