package com.zhaoya.hgshop.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.dao.CartDao;
import com.zhaoya.hgshop.dao.OrderDao;
import com.zhaoya.hgshop.dao.UserDao;
import com.zhaoya.hgshop.pojo.Cart;
import com.zhaoya.hgshop.pojo.OrderDetail;
import com.zhaoya.hgshop.pojo.Orders;
import com.zhaoya.hgshop.pojo.User;
import com.zhaoya.hgshop.service.UserService;

/**
 * 
 * @author 45466
 *
 */
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	CartDao cartDao;

	@Autowired
	OrderDao orderDao;

	public int register(User user) {
		// TODO Auto-generated method stub
		// 判断是否存在同名的用户
		User existUser = userDao.findByUsername(user.getName());
		if(existUser!=null)
			return -1;
		//加盐（mysalt）  加密
		String md5Str = DigestUtils.md5Hex(user.getPassword() + "mysalt");
		user.setPassword(md5Str);
		
		return userDao.add(user);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		//加盐（mysalt）  加密  转换成秘文去数据库中查询
		String md5Str = DigestUtils.md5Hex(user.getPassword() + "mysalt");
		user.setPassword(md5Str);
		return userDao.findUser(user);
		
	}

	@Override
	public int addCart(int uid, int skuId, int num) {
		// TODO Auto-generated method stub
		return cartDao.add(uid, skuId, num);
	}

	@Override
	public List<Cart> listCart(int userId) {
		// TODO Auto-generated method stub
		return cartDao.listByUserId(userId);
	}

	@Override
	public int deleteBatchCart(int userId, int[] ids) {
		// TODO Auto-generated method stub
		return cartDao.deleteBatch(userId, ids);
	}

	@Override
	public PageInfo<Orders> listOders(int page, int userId) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		return new PageInfo<Orders>(orderDao.list(userId));
	}

	@Override
	public Orders getOderById(int id) {
		// TODO Auto-generated method stub
		return orderDao.getById(id);
	}

	@Override
	public int createOrder(int userId, String address, int[] ids) {

		// 从数据库中再获取一次sku/cart的列表

		List<Cart> cartList = cartDao.list(ids);

		// TODO Auto-generated method stub
		// 生成订单的实体Bean
		Orders order = new Orders();
		order.setUid(userId);
		order.setAddress(address);
		// 计算订单的总价格
		BigDecimal orderTotal = new BigDecimal(0);
		for (Cart cart : cartList) {
			// 单价 * 购买数量
			orderTotal = orderTotal.add(cart.getSku().getPrice().multiply(new BigDecimal(cart.getPnum())));
		}

		// 得到总价格
		order.setSumtotal(orderTotal);
		// 生成订单主表
		int result = orderDao.createOrder(order);

		// 生成订单明细表
		for (Cart cart : cartList) {
			OrderDetail detail = new OrderDetail();
			detail.setSkuId(cart.getSkuid());
			detail.setOid(order.getOid());// 主表的id
			detail.setPnum(cart.getPnum());
			// 明细的价格
			detail.setTotal(cart.getSku().getPrice().multiply(new BigDecimal(cart.getPnum())));
			result += orderDao.createOrderDetail(detail);
		}
		cartDao.deleteBatch(userId, ids);
		return result;
	}

}
