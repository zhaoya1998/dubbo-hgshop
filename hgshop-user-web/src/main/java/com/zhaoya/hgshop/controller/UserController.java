package com.zhaoya.hgshop.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaoya.hgshop.pojo.Cart;
import com.zhaoya.hgshop.pojo.User;
import com.zhaoya.hgshop.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	
	@Reference
	UserService userService;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("tologin")
	public String toLogin() {
		return "user/login";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("home")
	public String home(HttpServletRequest request) {
		User loginUser = (User)request.getSession().getAttribute("SESSION_KEY");
		if(loginUser==null) {
			//��δ��¼
			return "redirect:/user/login";
		}
		return "user/home";
		
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("toregister")
	public String toRegister() {
		return "user/register";
	}
	
	@RequestMapping("register")
	public String register(HttpServletRequest request, User user,String code) {
		
		
		/**
		 * ע��
		 */
		//  ��session�л�ȡ��֤��
		String codeInSession = (String)request.getSession().getAttribute("code");
		//��֤�벻һ��
		if(code==null || !code.equals(codeInSession)) {
			request.getSession().removeAttribute("code");//
			request.setAttribute("error", "��֤��ʧ��");
			return "user/register";
			
		}
		
		int result = userService.register(user);
		if(result<1) {
			request.setAttribute("error", "ע��ʧ��");
			return "user/register";
		}
		
		//ע��ɹ�
		return "redirect:/user/tologin";
		
	}
	
	
	@RequestMapping("login")
	public String login(HttpServletRequest request, User user) {
		
		User loginUser = userService.login(user);
		
		if(loginUser==null) {
			request.setAttribute("error", "��¼ʧ��");
			request.getSession().removeAttribute("SESSION_KEY");
			return "user/login";
		}
		
		// ���session
		request.getSession().setAttribute("SESSION_KEY",loginUser);
		
		//��¼�ɹ�
		return "redirect:/user/home";
		
	}
	
	/**
	 * ���빺�ﳵ
	 * @param skuId
	 * @param num
	 * @return
	 */
	@RequestMapping("addCart")
	@ResponseBody
	public String addCart(HttpServletRequest request, int skuId,int num) {
		User loginUser = (User)request.getSession().getAttribute("SESSION_KEY");
		if(loginUser==null) {
			//��δ��¼
			return "pls login!";
		}
		//���빺�ﳵ
		int result = userService.addCart(loginUser.getUid(),skuId,num);
		
		return result>0? "success":"failed to add cart";
	}
	
	/**
	 * 
	 * @param request
	 */
	@RequestMapping("listcart")
	public   String listCart(HttpServletRequest request) {
		
		User loginUser = (User)request.getSession().getAttribute("SESSION_KEY");
		if(loginUser==null) {
			//��δ��¼
			request.setAttribute("errorInfo", "��δ��¼");
			return "error";
		}
		
		List<Cart> listCart = userService.listCart(loginUser.getUid());
		request.setAttribute("listCart", listCart);
		return "user/cartlist";
		
	}
	
	/**
	 * 
	 * @param request
	 * @param address �����ַ
	 * @param ids  ���ﳵ��id����
	 * @return
	 */
	@RequestMapping("createOrder")
	@ResponseBody
	public String createOrder(HttpServletRequest request,@RequestParam("address") String address,@RequestParam("ids[]") int[] ids) {
		
		System.out.println(" ids is " + ids);
		User loginUser = (User)request.getSession().getAttribute("SESSION_KEY");
		int result = userService.createOrder(loginUser.getUid(), address, ids);
		return result>0?"success":"failed";
	}
	
	@RequestMapping("getCode")
	@ResponseBody
	public String getCode(HttpServletRequest request) {
		//������֤��
		// TODO Auto-generated method stub
		Random random = new Random();
		String s = "";
		for (int i = 0; i < 4; i++) {
			char c = (char) ('a' + random.nextInt(26));
			s += c; 
		}
		System.err.print("  ��֤���ǣ� " + s);
		//���浽session����
		request.getSession().setAttribute("code", s);
		
		return s;
		
	}
	
	
	
	
}
