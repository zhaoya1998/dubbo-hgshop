package com.zhaoya.hgshop.controller;

import java.io.IOException;
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
import com.zhaoya.hgshop.pojo.Brand;
import com.zhaoya.hgshop.pojo.Spu;
import com.zhaoya.hgshop.pojo.SpuVo;
import com.zhaoya.hgshop.service.BrandService;
import com.zhaoya.hgshop.service.SpuService;

/***
 * 商品的管理
 * 
 * @author zhuzg
 *
 */
@Controller
@RequestMapping("spu")
public class SpuController {

	@Reference
	SpuService spuService;

	@Reference
	BrandService brandService;

	/**
	 * 列表
	 * 
	 * @param request
	 * @param spuVo
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request, SpuVo spuVo, @RequestParam(defaultValue = "1") int page) {

		PageInfo<Spu> pageInfo = spuService.list(page, spuVo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("spuVo", spuVo);
		return "spu/list";
	}

	/**
	 * 进入添加的页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("toadd")
	public String toAdd(HttpServletRequest request) {

		List<Brand> brandList = brandService.listByFirst("");
		request.setAttribute("brandList", brandList);
		return "spu/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request, Spu spu, @RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {

		// 上传文件
		String filePath = FileUtils.processFile(file);
		// 设置图片路径
		spu.setSmallPic(filePath);

		int result = spuService.add(spu);

		return result > 0 ? "success" : "failed";

	}

	/**
	 * 进入修改的页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("toupdate")
	public String toUpdate(HttpServletRequest request, int id) {

		// 获取所有的品牌列表
		List<Brand> brandList = brandService.listByFirst("");
		request.setAttribute("brandList", brandList);

		// 获取要修改的数据 进行回显
		Spu spu = spuService.getById(id);
		request.setAttribute("spu", spu);

		return "spu/update";
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
		int i = spuService.deleteBatch(ids);
		return i > 0 ? "success" : "failed";

	}

	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request, Spu spu, @RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {

		// 上传文件
		String filePath = FileUtils.processFile(file);
		// 设置图片路径
		spu.setSmallPic(filePath);

		int result = spuService.update(spu);

		return result > 0 ? "success" : "failed";

	}

}
