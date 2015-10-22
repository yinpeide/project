package com.itcast.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ajax2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username = request.getParameter("username");
			System.out.println(username);
			if("admin".equals(username)){
				//request.getRequestDispatcher("/PrjAjaxStudy1/result1.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath() +"ajax/result1.jsp");
			}else{
				//request.getRequestDispatcher("/PrjAjaxStudy1/result2.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath() +"ajax/result2.jsp");
			}
	}
}
