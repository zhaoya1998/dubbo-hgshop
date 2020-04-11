package com.zhaoya.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Brand;

public interface BrandService {
	
	/**
	 * ��������ĸ��ѯ
	 * @param firstChar  
	 * @return
	 */
	List<Brand> listByFirst(String firstChar);
	
	PageInfo<Brand> list(int page);

	Brand brandById(int id);

	int update(Brand brand);
	

}
