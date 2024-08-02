package com.springboot.user_devops.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.springboot.user_devops.model.User;
import com.springboot.user_devops.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private UserRepository repository;
	
	public User getUserById(Long id) {
		Optional<User> user = this.repository.findById(id);
		if(!user.isEmpty()) {
			return user.get();
		}
		return null;
	}
}
