package com.itcast.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @discription
 * @author 尹培德
 * @Time 2015年7月21日上午10:18:51
 */

@Controller
public class HomeController {
	
	//这里要中注解方式，先是业务，再是跳转
	@RequestMapping( "/home.action")
	public String getHome(HttpServletRequest request){
		System.out.println(request.getRequestURI());
		return "index";
	}

}
