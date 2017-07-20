package com.cervus.nippon.antoangiaothong;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cervus.nippon.antoangiaothong.entity.User;
import com.cervus.nippon.antoangiaothong.repository.UserRepo;

@RestController
public class MyRestController {
	
	@Autowired
	private UserRepo uRepo;
	
	@GetMapping("/" )
	public String[] home(HttpServletRequest request) {
		List<User> list = uRepo.findAll();
		return new String[] { "hoang van kien", "hoang van kien", "hoang van kien" };
	}
}