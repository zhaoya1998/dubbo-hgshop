package com.zhaoya.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Sku;
import com.zhaoya.hgshop.pojo.SkuVo;

/**
 * sku �Ĺ���
 *
 */
public interface SkuService {
	
	//
	int add(Sku sku);
	
	int deleteBatch(int ids[]);
	
	//�޸�
	int update(Sku sku);
		
	PageInfo<Sku> list(int page,SkuVo skuVo);
		
	// ��ȡһ��sku  �޸Ļ��� ��������
	Sku getById(int id);
	
	/**
	 * 
	 * @param spuId
	 * @return
	 */
	List<Sku> getBySpuId(int spuId);
	
	
	
}
