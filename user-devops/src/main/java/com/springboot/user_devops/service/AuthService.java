package com.springboot.user_devops.service;

import org.springframework.stereotype.Service;

import com.springboot.user_devops.dto.SignupDTO;
import com.springboot.user_devops.dto.UserDTO;


@Service
public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}