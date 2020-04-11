package com.zhaoya.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.hgshop.pojo.Sku;
import com.zhaoya.hgshop.pojo.SkuVo;
import com.zhaoya.hgshop.pojo.SpecOption;


public interface SkuDao {

	int add(Sku sku);

	/**
	 * 
	 * @param skuId skuId
	 * @param specOption  ����Ĺ�������ֵ
	 * @return
	 */
	int addSkuSpec(@Param("skuId") Integer skuId, @Param("specOpt") SpecOption specOption);

	int deleteBatch(int[] ids);

	
	int deleteSkuSpec(int...ids);

	int update(Sku sku);

	//int deleteSkuSpec(Integer id);

	List<Sku> list(SkuVo skuVo);

	Sku getById(int id);

	/**
	 * ������Ʒid��ȡ���е�sku��
	 * @param spuId
	 * @return
	 */
	List<Sku> getBySpuId(int spuId);

	/**
	 * ����spu id ɾ�� sku
	*/
	int deleteBatchBySpu(int[] ids);

	/**
	 * ����spu ɾ��sku ������ 
	 * @param ids
	 * @return
	 */
	int deleteSkuSpecBySpu(int[] ids);

}
