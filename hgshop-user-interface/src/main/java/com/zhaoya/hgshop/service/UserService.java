package com.zhaoya.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Cart;
import com.zhaoya.hgshop.pojo.Orders;
import com.zhaoya.hgshop.pojo.User;

/**
 * 用户的接口
 * 
 * @author 45466
 *
 */
public interface UserService {
	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	int register(User user);

	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * 加入购物车
	 * 
	 * @param skuId
	 * @param num
	 * @return
	 */
	int addCart(int uid, int skuId, int num);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	List<Cart> listCart(int userId);

	// 删除
	int deleteBatchCart(int userId, int[] ids);

	// 生成订单
	int createOrder(int userId, String address, int[] ids);

	// 订单列表
	PageInfo<Orders> listOders(int page, int userId);

	/**
	 * 订单详情
	 * 
	 * @param id
	 * @return
	 */
	Orders getOderById(int id);

}
