package com.springboot.user_devops.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.user_devops.model.User;
import com.springboot.user_devops.dto.UserDTO;
import com.springboot.user_devops.service.UserService;

import com.springboot.user_devops.mapper.UserMapper;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
	
	private UserService service;
	
	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUser() {
		System.out.println("Tatjana");
		
		User user = this.service.getUserById((long) 1);
		if(user.equals(null)) {
		    return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(UserMapper.mapToUserDTO(user));
	}
	
}
