package com.itcast.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itcast.entity.LoginInfo;
import com.itcast.service.LoginInfoService;

@Controller
public class LoginController extends BaseController{
	
	@Resource(name="loginInfoService")
	private LoginInfoService loginInfoService; 
	
	//这里只写登陆和登出方法，登入登出分别把session加入或者减去
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("login.action")
	public String login(String name,String passwd,Model model,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("passwd", passwd);
		List<LoginInfo> loginDataList =  loginInfoService.findList(map);
		if(loginDataList.size() > 0){
			session.setAttribute("name",name);
			model.addAttribute("loginDataList", loginDataList);
			return "redirect:/person/list.action";
		}else{
				model.addAttribute("error", "亲爱的，您还没有权限登录系统哦");
				return "login.jsp";
		}
	}	
	
	/**
	 * 推出
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("logout.action")
	public String logout(Model model,HttpSession session){
			session.invalidate();
			return "redirect:/login.action";
	}
	
}
