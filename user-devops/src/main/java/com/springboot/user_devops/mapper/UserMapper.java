package com.springboot.user_devops.mapper;

import com.springboot.user_devops.dto.UserDTO;
import com.springboot.user_devops.model.User;

public class UserMapper {
	
	public static UserDTO mapToUserDTO(User user) {
		return new UserDTO(
				user.getId(), 
				user.getFirstName(), 
				user.getLastName(), 
				user.getUsername(),
				user.getEmail()
		);
	}
}