package com.zhaoya.hgshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.hgshop.pojo.Cart;
import com.zhaoya.hgshop.pojo.Goods;

public interface GoodsDao {

	ArrayList<Goods> all();

}
