package com.zhaoya.hgshop.service.impl;

import java.util.ArrayList;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhaoya.hgshop.dao.GoodsDao;
import com.zhaoya.hgshop.pojo.Goods;
import com.zhaoya.hgshop.service.GoodsService;

@Service(interfaceClass = GoodsService.class)
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	GoodsDao goodsDao;

	@Override
	public ArrayList<Goods> all() {
		// TODO Auto-generated method stub
		return goodsDao.all();
	}

}
