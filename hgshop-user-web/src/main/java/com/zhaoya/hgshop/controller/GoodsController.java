package com.zhaoya.hgshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhaoya.hgshop.pojo.Goods;
import com.zhaoya.hgshop.pojo.Sku;
import com.zhaoya.hgshop.pojo.Spu;
import com.zhaoya.hgshop.service.GoodsService;
import com.zhaoya.hgshop.service.SkuService;
import com.zhaoya.hgshop.service.SpuService;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Reference
	SpuService spuService;

	@Reference
	SkuService skuService;
	
	@Reference
	GoodsService goodsService;

	/**
	 * 
	 * @param request
	 * @param id      spu µÄid
	 * @return
	 */
	@RequestMapping("detail")
	public String getDetail(HttpServletRequest request, int id) {

		Spu spu = spuService.getById(id);
		request.setAttribute("spu", spu);

		List<Sku> list = skuService.getBySpuId(id);
		request.setAttribute("skuList", list);

		return "goods/detail";
	}
	
	@RequestMapping("all")
	public String all(HttpServletRequest request) {
		ArrayList<Goods> list=goodsService.all();
		request.setAttribute("list", list);
		return "user/all";
	}
}
