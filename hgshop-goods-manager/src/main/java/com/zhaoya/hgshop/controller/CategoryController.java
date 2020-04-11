package com.zhaoya.hgshop.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaoya.hgshop.pojo.Category;
import com.zhaoya.hgshop.service.CategoryService;



@RequestMapping("cat")
@Controller
public class CategoryController {
	
	@Reference
	CategoryService catService;

	@RequestMapping("tree")
	public String tree() {
		return "category/tree";
	}
	

	/**
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("treeData")
	public List<Category> treeData() {
		List<Category> catTree = catService.getTree();
		return catTree;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public String add(Category cat) {
		int re=  catService.add(cat);
		return re>0?"success":"failed";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update(Category cat) {
		int re=  catService.update(cat);
		return re>0?"success":"failed";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(int id) {
		int re=  catService.delete(id);
		return re>0?"success":"failed";
	}
	
	
}
