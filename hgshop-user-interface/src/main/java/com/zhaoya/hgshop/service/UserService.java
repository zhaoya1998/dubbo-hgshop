package com.zhaoya.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Cart;
import com.zhaoya.hgshop.pojo.Orders;
import com.zhaoya.hgshop.pojo.User;

/**
 * �û��Ľӿ�
 * 
 * @author 45466
 *
 */
public interface UserService {
	/**
	 * ע��
	 * 
	 * @param user
	 * @return
	 */
	int register(User user);

	/**
	 * ��¼
	 * 
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * ���빺�ﳵ
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

	// ɾ��
	int deleteBatchCart(int userId, int[] ids);

	// ���ɶ���
	int createOrder(int userId, String address, int[] ids);

	// �����б�
	PageInfo<Orders> listOders(int page, int userId);

	/**
	 * ��������
	 * 
	 * @param id
	 * @return
	 */
	Orders getOderById(int id);

}
