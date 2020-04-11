package com.zhaoya.hgshop.dao;

import java.util.List;

import com.zhaoya.hgshop.pojo.OrderDetail;
import com.zhaoya.hgshop.pojo.Orders;

public interface OrderDao {

	List<Orders> list(int userId);

	Orders getById(int id);
	
	int createOrder(Orders order);

	int createOrderDetail(OrderDetail od);

}
