package com.zhaoya.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Sku;
import com.zhaoya.hgshop.pojo.SkuVo;

/**
 * sku 的管理
 *
 */
public interface SkuService {
	
	//
	int add(Sku sku);
	
	int deleteBatch(int ids[]);
	
	//修改
	int update(Sku sku);
		
	PageInfo<Sku> list(int page,SkuVo skuVo);
		
	// 获取一个sku  修改回显 或者详情
	Sku getById(int id);
	
	/**
	 * 
	 * @param spuId
	 * @return
	 */
	List<Sku> getBySpuId(int spuId);
	
	
	
}
