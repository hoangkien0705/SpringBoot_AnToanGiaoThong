package com.cervus.nippon.antoangiaothong.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervus.nippon.antoangiaothong.entity.User;
import com.cervus.nippon.antoangiaothong.repository.UserRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepo uRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		User user = uRepo.findByUsername(username);
		if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		user.getUserRoles();
		List<String> arr = uRepo.findRoleByIdUser(user.getId());
		for (String string : arr) {
			grantedAuthorities.add(new SimpleGrantedAuthority(string));
		}
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantedAuthorities);
		return userDetails;
	}

}
