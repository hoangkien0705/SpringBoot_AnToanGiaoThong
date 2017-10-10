/*package com.cervus.nippon.antoangiaothong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervus.nippon.antoangiaothong.entity.User;
import com.cervus.nippon.antoangiaothong.repository.UserRepo;

@Service
@Transactional
@Lazy
public class SecurityService {
	
	@Autowired
	private UserRepo userRepo;
	
	public UserDetailsImp loadUser(String username) {
		User u = userRepo.findByUsername(username);
		if (u == null)
			return null;
		return mapFromEntity(u);
	}
	
	private UserDetailsImp mapFromEntity(User u) {
		UserDetailsImp userDetailsImp = new UserDetailsImp();
		userDetailsImp.setUsername(u.getUsername());
		userDetailsImp.setPassword(u.getPassword());
		userDetailsImp.setEmail(u.getEmail());
//		userDetailsImp.setAuthorities(authorities);
		return userDetailsImp;
	} 

}
*/