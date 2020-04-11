package com.zhaoya.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhaoya.hgshop.dao.BrandDao;
import com.zhaoya.hgshop.pojo.Brand;
import com.zhaoya.hgshop.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service(interfaceClass=BrandService.class)
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	BrandDao brandDao;
	

	@Override
	public List<Brand> listByFirst(String firstChar) {
		// TODO Auto-generated method stub
		return brandDao.listByFirstChar(firstChar);
	}

	@Override
	public PageInfo<Brand> list(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		
		return new PageInfo<Brand>(brandDao.list());
	}

	@Override
	public int update(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.update(brand);
	}

	@Override
	public Brand brandById(int id) {
		// TODO Auto-generated method stub
		return brandDao.getById(id);
	}

}
