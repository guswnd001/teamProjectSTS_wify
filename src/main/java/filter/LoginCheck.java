package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheck extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if(request.getSession().getAttribute("id") == null) {
			response.sendRedirect(request.getContextPath() + "/member/login");
		}
		
		return super.preHandle(request, response, handler);
	}
	
	
	
	
}
