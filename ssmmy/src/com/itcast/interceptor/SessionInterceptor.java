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

import com.itcast.exception.AuthorizationException;

/**
 * @author 尹培德
 * @time 2015年8月2日下午5:46:11
 */
public class SessionInterceptor implements HandlerInterceptor {

    private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
        // excluded URLs:
        // see http://stackoverflow.com/questions/9908124/spring-mvc-3-interceptor-on-all-excluding-some-defined-paths
        String requestUri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }
        
        // intercept
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            // see http://stackoverflow.com/questions/12713873/spring-3-1-how-do-you-send-all-exception-to-one-page
				throw new AuthorizationException();
        } else {
            return true;
        }
	}

}
