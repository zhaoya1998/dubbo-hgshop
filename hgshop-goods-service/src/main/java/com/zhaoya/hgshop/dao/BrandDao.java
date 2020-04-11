package com.zhaoya.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.hgshop.pojo.Brand;


public interface BrandDao {
	
	

	List<Brand> listByFirstChar(@Param("firstChar") String firstChar);

	List<Brand> list();

	int update(Brand brand);

	Brand getById(int id);
	
}
