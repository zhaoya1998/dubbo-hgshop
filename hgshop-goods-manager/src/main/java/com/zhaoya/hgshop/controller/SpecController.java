package com.zhaoya.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhaoya.hgshop.pojo.Spec;
import com.zhaoya.hgshop.pojo.SpecOption;
import com.zhaoya.hgshop.service.SpecService;

/**
 * 规格的管理
 * @author zhuzg
 *
 */
@Controller
@RequestMapping("spec")
public class SpecController {
	
	@Reference
	SpecService specService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,
			@RequestParam(defaultValue="") String name,
			@RequestParam(defaultValue="1") int page)
	{
		PageInfo<Spec> pageInfo = specService.list(name, page);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("name", name);
		
		return "spec/list";
	}
	
	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest request,int id) {
		Spec spec = specService.findById(id);
		System.out.println("spec" + spec);
		request.setAttribute("spec", spec);
		return "spec/update";
	}
	
	/**
	 * 跳转到添加页面
	 * @param request
	 * @return
	 */
	@RequestMapping("toadd")
	public String toadd(HttpServletRequest request) {
		return "spec/add";
	}
	
	
	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request,Spec spec) {
		
		System.out.println("spec" + spec);
		request.setAttribute("spec", spec);
		//处理空数据
		List<SpecOption> optionList = spec.getOptionList();
		
		// 过滤空数据
		
		for (int i = optionList.size(); i > 0; i--) {
			SpecOption option = optionList.get(i-1);
			if(option.getOptionName()==null && option.getOrders()==0) {
				optionList.remove(i-1);
			}
			option.setSpecId(spec.getId());
		}
		
		return  specService.update(spec)>0?"success":"failed";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request,Spec spec) {
		
		System.out.println("spec" + spec);
		request.setAttribute("spec", spec);
		//处理空数据
		List<SpecOption> optionList = spec.getOptionList();
		
		// 过滤空数据
		
		for (int i = optionList.size(); i > 0; i--) {
			SpecOption option = optionList.get(i-1);
			if(option.getOptionName()==null && option.getOrders()==0) {
				optionList.remove(i-1);
			}
			//option.setSpecId(spec.getId());
		}
		
		return  specService.add(spec)>0?"success":"failed";
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("delBatch")
	@ResponseBody
	public String delBatch(@RequestParam("ids[]") int ids[]) {
		int i = specService.deleteBatch(ids);
		return i>0?"success":"failed";
		
	}
	
	/**
	 * 获取某一个规格的所有的属性值
	 * @param specId
	 * @return
	 */
	@RequestMapping("getOptions")
	@ResponseBody
	public List<SpecOption> getOptions(int specId ){
		Spec spec = specService.findById(specId);
		return spec.getOptionList();
		
	}
}
