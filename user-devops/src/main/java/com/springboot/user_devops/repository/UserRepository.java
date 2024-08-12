package com.springboot.user_devops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.user_devops.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	 User findFirstByEmail(String email);
	 User findFirstByUsername(String username);
}
