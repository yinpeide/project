/**
 *ade
 *2015年10月19日
 * 
 */
package com.itcast.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 尹培德
 * @time 2015年10月19日下午10:54:06
 */
public class IpAccessFilter implements Filter {
	//private String ipaddress;
	//要是ip是多个的话就要用到集合了
	private List<String> ipList = new ArrayList<String>();
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			
			String ip = request.getRemoteHost();
			if(ipList.contains(ip)){
				System.out.println("OK");
				chain.doFilter(request, response);
			}else{
				HttpServletRequest req = (HttpServletRequest)request;
				HttpServletResponse resp = (HttpServletResponse)response;
				resp.sendRedirect(req.getContextPath()+"/error.jsp");
			}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//String ipaddress = filterConfig.getInitParameter("ipaddress");
		//this.ipaddress = ipaddress;
		//这里获取ip的数组
		String ipaddress = filterConfig.getInitParameter("ipaddress");
		String [] ips = ipaddress.split(",");
		//把ip地址存到集合中去
		for(int i=0;i<ips.length;i++){
			ipList.add(ips[i]);
		}
	}
}

