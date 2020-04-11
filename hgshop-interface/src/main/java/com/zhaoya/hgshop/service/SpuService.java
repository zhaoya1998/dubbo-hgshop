package com.zhaoya.hgshop.service;


import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Spu;
import com.zhaoya.hgshop.pojo.SpuVo;

public interface SpuService {
	
	/**
	 * 
	 * @param page
	 * @param spuVo  查询条件
	 * @return
	 */
	PageInfo<Spu> list(int page,SpuVo spuVo);
	
	int add(Spu spu);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	int deleteBatch(int ids[]);
	
	/**
	 * 
	 * @param spu
	 * @return
	 */
	int update(Spu spu);
	
	/**
	 * 
	 * @param id
	 * @param marketable 1 在售  0 未售
	 * @return
	 */
	int updateMarkable(int id,int marketable);
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	Spu getById(int id);
	
	
}
