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
		// �ж��Ƿ����ͬ�����û�
		User existUser = userDao.findByUsername(user.getName());
		if(existUser!=null)
			return -1;
		//���Σ�mysalt��  ����
		String md5Str = DigestUtils.md5Hex(user.getPassword() + "mysalt");
		user.setPassword(md5Str);
		
		return userDao.add(user);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		//���Σ�mysalt��  ����  ת��������ȥ���ݿ��в�ѯ
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

		// �����ݿ����ٻ�ȡһ��sku/cart���б�

		List<Cart> cartList = cartDao.list(ids);

		// TODO Auto-generated method stub
		// ���ɶ�����ʵ��Bean
		Orders order = new Orders();
		order.setUid(userId);
		order.setAddress(address);
		// ���㶩�����ܼ۸�
		BigDecimal orderTotal = new BigDecimal(0);
		for (Cart cart : cartList) {
			// ���� * ��������
			orderTotal = orderTotal.add(cart.getSku().getPrice().multiply(new BigDecimal(cart.getPnum())));
		}

		// �õ��ܼ۸�
		order.setSumtotal(orderTotal);
		// ���ɶ�������
		int result = orderDao.createOrder(order);

		// ���ɶ�����ϸ��
		for (Cart cart : cartList) {
			OrderDetail detail = new OrderDetail();
			detail.setSkuId(cart.getSkuid());
			detail.setOid(order.getOid());// �����id
			detail.setPnum(cart.getPnum());
			// ��ϸ�ļ۸�
			detail.setTotal(cart.getSku().getPrice().multiply(new BigDecimal(cart.getPnum())));
			result += orderDao.createOrderDetail(detail);
		}
		cartDao.deleteBatch(userId, ids);
		return result;
	}

}
