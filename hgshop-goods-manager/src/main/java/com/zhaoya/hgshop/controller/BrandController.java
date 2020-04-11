package com.zhaoya.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Brand;
import com.zhaoya.hgshop.service.BrandService;


@Controller
@RequestMapping("brand")
public class BrandController {
	
	@Reference
	BrandService brandService;

	@RequestMapping("list")
	public String list(HttpServletRequest request, @RequestParam(defaultValue = "1") int page) {
		PageInfo<Brand> pageInfo = brandService.list(page);
		request.setAttribute("pageInfo", pageInfo);
		return "brand/list";
	}

	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest request, int id) {
		Brand brand = brandService.brandById(id);
		request.setAttribute("brand", brand);
		return "brand/update";

	}

	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request, Brand brand) {
		System.out.println("brand" + brand);
		request.setAttribute("brand", brand);

		return brandService.update(brand) > 0 ? "success" : "failed";

	}

}
