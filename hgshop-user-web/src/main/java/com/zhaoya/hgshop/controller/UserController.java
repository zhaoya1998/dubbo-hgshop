package com.zhaoya.hgshop.controller;

import java.util.List;

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
		User loginUser = (User) request.getSession().getAttribute("SESSION_KEY");
		if (loginUser == null) {
			// ÉÐÎ´µÇÂ¼
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
	public String register(HttpServletRequest request, User user) {

		/**
		 * ×¢²á
		 */
		int result = userService.register(user);
		if (result < 1) {
			request.setAttribute("error", "×¢²áÊ§°Ü");
			return "user/register";
		}

		// ×¢²á³É¹¦
		return "redirect:/user/tologin";

	}

	@RequestMapping("login")
	public String login(HttpServletRequest request, User user) {

		User loginUser = userService.login(user);

		if (loginUser == null) {
			request.setAttribute("error", "µÇÂ¼Ê§°Ü");
			request.getSession().removeAttribute("SESSION_KEY");
			return "user/login";
		}

		// ´æ·Åsession
		request.getSession().setAttribute("SESSION_KEY", loginUser);

		// µÇÂ¼³É¹¦
		return "redirect:/user/home";

	}

	/**
	 * ¼ÓÈë¹ºÎï³µ
	 * 
	 * @param skuId
	 * @param num
	 * @return
	 */
	@RequestMapping("addCart")
	@ResponseBody
	public String addCart(HttpServletRequest request, int skuId, int num) {
		User loginUser = (User) request.getSession().getAttribute("SESSION_KEY");
		if (loginUser == null) {
			// ÉÐÎ´µÇÂ¼
			return "pls login!";
		}
		// ¼ÓÈë¹ºÎï³µ
		int result = userService.addCart(loginUser.getUid(), skuId, num);

		return result > 0 ? "success" : "failed to add cart";
	}

	/**
	 * 
	 * @param request
	 */
	@RequestMapping("listcart")
	public String listCart(HttpServletRequest request) {

		User loginUser = (User) request.getSession().getAttribute("SESSION_KEY");
		if (loginUser == null) {
			// ÉÐÎ´µÇÂ¼
			request.setAttribute("errorInfo", "ÉÐÎ´µÇÂ¼");
			return "error";
		}

		List<Cart> listCart = userService.listCart(loginUser.getUid());
		request.setAttribute("listCart", listCart);
		return "user/cartlist";

	}

	/**
	 * 
	 * @param request
	 * @param address Åä»õµØÖ·
	 * @param ids     ¹ºÎï³µµÄidÊý×é
	 * @return
	 */
	@RequestMapping("createOrder")
	@ResponseBody
	public String createOrder(HttpServletRequest request, @RequestParam("address") String address,
			@RequestParam("ids[]") int[] ids) {

		System.out.println(" ids is " + ids);
		User loginUser = (User) request.getSession().getAttribute("SESSION_KEY");
		int result = userService.createOrder(loginUser.getUid(), address, ids);
		return result > 0 ? "success" : "failed";
	}

}
