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
	 * @param specOption  具体的规格和属性值
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
	 * 根据商品id获取所有的sku。
	 * @param spuId
	 * @return
	 */
	List<Sku> getBySpuId(int spuId);

	/**
	 * 根据spu id 删除 sku
	*/
	int deleteBatchBySpu(int[] ids);

	/**
	 * 根据spu 删除sku 的属性 
	 * @param ids
	 * @return
	 */
	int deleteSkuSpecBySpu(int[] ids);

}
