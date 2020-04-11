package com.zhaoya.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.hgshop.pojo.Spu;
import com.zhaoya.hgshop.pojo.SpuVo;



public interface SpuDao {

	List<Spu> list(SpuVo spuVo);

	int add(Spu spu);

	int deleteBatch(int[] ids);

	Spu getById(int id);

	int update(Spu spu);

	int updateMarkable(@Param("id") int id,
			@Param("isMarketable") int marketable);
}
