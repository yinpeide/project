package com.itcast.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ajax1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("html/text;charset=GB18030");
		String username = request.getParameter("username");
		
		PrintWriter out = response.getWriter();
		if("admin".equals(username)){
			out.print("用户名已被注册");
			
		}else{
			
			out.print("用户名可用");
		}
	}
}
