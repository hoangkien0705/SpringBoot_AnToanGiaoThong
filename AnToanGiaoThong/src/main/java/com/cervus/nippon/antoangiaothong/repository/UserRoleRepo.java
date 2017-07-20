package com.cervus.nippon.antoangiaothong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cervus.nippon.antoangiaothong.entity.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
	
	@Query(value ="SELECT * FROM USER_ROLE WHERE USER_ID = ?1", nativeQuery = true)
	List<UserRole> findByUserId(long id);
}
