package com.cervus.nippon.antoangiaothong;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cervus.nippon.common.Log;

@Controller
public class WebController {
	
	@RequestMapping(value = "/demo", method = { RequestMethod.GET })
	public String home() {
		return "home";
	}
	@RequestMapping(value = "/error", method = { RequestMethod.GET })
	public String error() {
		return "error";
	}
	
	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login_error", method = { RequestMethod.GET })
	public String errlogin() {
		return "login_error";
	}
	
	@RequestMapping(value = "/login_success", method = { RequestMethod.GET })
	public String loginSuccess() {
		return "login_success";
	}
	
	@RequestMapping(value = "/logout_success", method = { RequestMethod.GET })
	public String logutSuccess() {
		return "login_success";
	}
	
	@RequestMapping(value = "/register", method = { RequestMethod.GET })
	public String register(@CurrentUser UserDetails userDetail) {
		Log.e(userDetail.getUsername());
		return "login_success";
	}
//comment su thay doi

	
}

