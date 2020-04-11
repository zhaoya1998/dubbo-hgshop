package com.zhaoya.hgshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.common.FileUtils;
import com.zhaoya.hgshop.pojo.Sku;
import com.zhaoya.hgshop.pojo.SkuVo;
import com.zhaoya.hgshop.pojo.Spec;
import com.zhaoya.hgshop.pojo.SpecOption;
import com.zhaoya.hgshop.pojo.Spu;
import com.zhaoya.hgshop.service.SkuService;
import com.zhaoya.hgshop.service.SpecService;
import com.zhaoya.hgshop.service.SpuService;

@Controller
@RequestMapping("sku")
public class SkuController {

	@Reference
	SkuService skuService;

	@Reference
	SpuService spuService;

	@Reference
	SpecService specService;

	/**
	 * 
	 * @param request
	 * @param skuVo
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request, SkuVo skuVo, @RequestParam(defaultValue = "1") int page) {

		// 获取数据
		PageInfo<Sku> pageInfo = skuService.list(page, skuVo);

		// 查询条件回显
		request.setAttribute("skuVo", skuVo);
		request.setAttribute("pageInfo", pageInfo);
		return "sku/list";

	}

	/**
	 * 根据商品添加sku
	 * 
	 * @param request
	 * @param spuId
	 * @return
	 */
	@RequestMapping("toadd")
	public String toAdd(HttpServletRequest request, int spuId) {

		Spu spu = spuService.getById(spuId);
		// 获取所有的规格
		// specList
		List<Spec> specList = specService.listAll();

		request.setAttribute("spu", spu);

		request.setAttribute("specList", specList);
		return "sku/add";
	}

	/**
	 * sku 的添加
	 * 
	 * @param request
	 * @param sku
	 * @param specId    规格id的数组
	 * @param optionId  属性数值id的数组
	 * @param imageFile sku的图片
	 * @param cartFile  购物车小图的数组
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request, Sku sku, int[] specId, int[] optionId, MultipartFile imageFile,
			MultipartFile cartFile) {

		// 构建sku的属性
		List<SpecOption> specOptionList = new ArrayList<>();
		for (int i = 0; i < specId.length && i < optionId.length; i++) {
			SpecOption option = new SpecOption();
			option.setId(optionId[i]);
			option.setSpecId(specId[i]);
			// 添加到集合中
			specOptionList.add(option);
		}
		// 将集合添加到封装bean中
		sku.setSpecOptionList(specOptionList);
		System.out.println("sku === " + sku);
		// 上传图片
		try {
			sku.setImage(FileUtils.processFile(imageFile));
			sku.setCartThumbnail(FileUtils.processFile(cartFile));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("sku === " + sku);

		return skuService.add(sku) > 0 ? "success" : "failed";

	}

	/**
	 * 根据商品添加sku
	 * 
	 * @param request
	 * @param spuId
	 * @return
	 */
	@RequestMapping("toupdate")
	public String toUpdate(HttpServletRequest request, int skuId) {

		Sku sku = skuService.getById(skuId);

		// 获取所有的规格
		// specList
		List<Spec> specList = specService.listAll();
		// 回显的数据
		request.setAttribute("sku", sku);
		request.setAttribute("specList", specList);
		return "sku/update";
	}

	/**
	 * sku 的添加
	 * 
	 * @param request
	 * @param sku
	 * @param specId    规格id的数组
	 * @param optionId  属性数值id的数组
	 * @param imageFile sku的图片
	 * @param cartFile  购物车小图的数组
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request, Sku sku, int[] specId, int[] optionId, MultipartFile imageFile,
			MultipartFile cartFile) {

		// 构建sku的属性
		List<SpecOption> specOptionList = new ArrayList<>();
		for (int i = 0; i < specId.length && i < optionId.length; i++) {
			SpecOption option = new SpecOption();
			option.setId(optionId[i]);
			option.setSpecId(specId[i]);
			// 添加到集合中
			specOptionList.add(option);
		}
		// 将集合添加到封装bean中
		sku.setSpecOptionList(specOptionList);
		System.out.println("sku === " + sku);
		// 上传图片
		try {
			sku.setImage(FileUtils.processFile(imageFile));
			sku.setCartThumbnail(FileUtils.processFile(cartFile));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("sku === " + sku);

		return skuService.update(sku) > 0 ? "success" : "failed";

	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("delBatch")
	@ResponseBody
	public String delBatch(@RequestParam("ids[]") int ids[]) {
		int i = skuService.deleteBatch(ids);
		return i > 0 ? "success" : "failed";

	}

}
