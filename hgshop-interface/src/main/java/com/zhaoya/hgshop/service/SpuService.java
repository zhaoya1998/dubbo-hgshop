package com.zhaoya.hgshop.service;


import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Spu;
import com.zhaoya.hgshop.pojo.SpuVo;

public interface SpuService {
	
	/**
	 * 
	 * @param page
	 * @param spuVo  ��ѯ����
	 * @return
	 */
	PageInfo<Spu> list(int page,SpuVo spuVo);
	
	int add(Spu spu);
	
	/**
	 * ����ɾ��
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
	 * @param marketable 1 ����  0 δ��
	 * @return
	 */
	int updateMarkable(int id,int marketable);
	
	/**
	 * ��ȡ����
	 * @param id
	 * @return
	 */
	Spu getById(int id);
	
	
}
