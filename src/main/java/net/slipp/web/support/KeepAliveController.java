package net.slipp.web.support;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/keepalive")
public class KeepAliveController {
	@RequestMapping("")
	public String keepAlive(){
		return "keepalive";
	}
}
