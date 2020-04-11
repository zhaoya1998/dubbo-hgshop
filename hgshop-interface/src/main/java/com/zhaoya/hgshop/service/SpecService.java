package com.zhaoya.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Spec;

/**
 * 规格管理的服务
 */
public interface SpecService {
	
	
	/**
	 * 
	 * @param spec
	 * @return
	 */
	int add(Spec spec);
	
	//修改
	int update(Spec spec);
		
	//详情  修改的回显
	Spec findById(int id);
	
	/**
	* 批量删除
	* @param ids
	* @return
	*/
	int deleteBatch(int[] ids);
	
	//分页查询
	PageInfo<Spec> list(String name,int page);
		
	//获取所有的规格
	List<Spec> listAll();
	
	
}
