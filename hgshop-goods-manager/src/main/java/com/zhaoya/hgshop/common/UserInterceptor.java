package com.zhaoya.hgshop.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class UserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws IOException {
		if(request.getSession().getAttribute(HgConstant.USER_KEY)==null) {
			response.sendRedirect("/admin/tologin");
			return false;
		}
		return false;
		
	}
}
