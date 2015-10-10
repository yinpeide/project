/**
 *ade
 *2015年8月2日
 * 
 */
package com.itcast.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 尹培德
 * @time 2015年8月2日下午5:46:11
 */
public class SessionInterceptor implements HandlerInterceptor {

    private List<String> allowUrls;

    public void setAllowUrls(List<String> allowUrls) {
		this.allowUrls = allowUrls;
	}

	// 前提必须是preHandle返回true
    //该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。这个方法的主要作用是用于进行资源清理工作的
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}
	
	// 前提必须是preHandle返回true
	//就是在当前请求进行处理之后，也就是Controller 方法调用之后执行
	//所以我们可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}
	
	//请求处理之前进行调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		//这是直接不拦截的url
        String requestUri = request.getRequestURI();
        for (String url : allowUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }
        // intercept
        HttpSession session = request.getSession();
        if (session.getAttribute("name") == null) {
        	//这里应该跳转到首页面了
    		response.sendRedirect(request.getContextPath()+"/index.jsp");
			return false;
        } else {
            return true;
        }
	}

}
