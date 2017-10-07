package com.cervus.nippon.antoangiaothong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	
	@GetMapping("/" )
	public String[] home(HttpServletRequest request) {
		return new String[] { "hoang van kien", "hoang van kien", "hoang van kien" };
	}
}