package com.cervus.nippon.antoangiaothong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cervus.nippon.antoangiaothong.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByUsername(String username);
	
	@Query(value ="SELECT NAME FROM ROLE WHERE ID = (SELECT ROLE_ID FROM USER_ROLE WHERE USER_ROLE.USER_ID = ?1)", nativeQuery = true)
	List<String> findRoleByIdUser(long id);
}
