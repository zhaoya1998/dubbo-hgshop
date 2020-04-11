package com.zhaoya.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.hgshop.pojo.Cart;

public interface CartDao {

	/**
	加入购物车
	*/
	int add(@Param("uid") int uid, @Param("skuId") int skuId, @Param("buyNum") int num);

	List<Cart> listByUserId(int userId);

	int deleteBatch(@Param("userId") int userId, @Param("ids") int[] ids);

	List<Cart> list(int[] ids);

}
