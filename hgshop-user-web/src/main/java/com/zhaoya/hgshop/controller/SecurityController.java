package com.zhaoya.hgshop.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaoya.hgshop.service.SecurityService;

@Controller
public class SecurityController {
	
	@Reference
	SecurityService ss;
	
	@RequestMapping("tojsp")
	public String tojsp() {
		return "jsp";
	}
	
	@RequestMapping("getkey")
	@ResponseBody
	public String getKey(HttpServletRequest request,HttpServletResponse reponse) {
		String key = ss.getKey();
		reponse.addCookie(new Cookie("mycookiekey", key));
		return key;
	}
}