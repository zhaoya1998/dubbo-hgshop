package com.zhaoya.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhaoya.hgshop.common.HgConstant;


@Controller
@RequestMapping("admin")
public class AdminController {

	/**
	 * 
	 * @return
	 */
	@RequestMapping("tologin")
	public String toLogin() {
		return "login";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public String login(HttpServletRequest request,String username,String password) {
		request.getSession().setAttribute(HgConstant.USER_KEY, username);
		return "redirect:/index";
	}
	
}
