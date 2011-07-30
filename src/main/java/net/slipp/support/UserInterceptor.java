package net.slipp.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class UserInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		UserService userService = UserServiceFactory.getUserService();
		request.setAttribute("isUserLoggedIn", userService.isUserLoggedIn());
		if( userService.isUserLoggedIn() ) {
			request.setAttribute("isUserAdmin", userService.isUserAdmin());			
			request.setAttribute("user", userService.getCurrentUser());
		} else {
			request.setAttribute("isUserAdmin", false);
		}
		return true;
	}
}
