package net.slipp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Controller
@RequestMapping("/signon")
public class SignonController {

	@RequestMapping("/login")
	public String login() {
		UserService userService = UserServiceFactory.getUserService();
		if(userService.isUserLoggedIn()){
			return "redirect:/";
		}
		
		return "redirect:" + userService.createLoginURL("/");
	}

	@RequestMapping("/logout")
	public String logout() {
		UserService userService = UserServiceFactory.getUserService();
		if(!userService.isUserLoggedIn()){
			return "redirect:/";
		}
		
		return "redirect:" + userService.createLogoutURL("/");
	}

}
