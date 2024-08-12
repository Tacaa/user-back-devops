package com.springboot.user_devops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.user_devops.dto.SignupDTO;
import com.springboot.user_devops.dto.UserDTO;
import com.springboot.user_devops.service.AuthService;

@RestController
public class SignupController {

//    @Autowired
//    private AuthService authService;
//
//    @PostMapping("/sign-up")
//    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO) {
//       UserDTO createdUser = authService.createUser(signupDTO);
//       if (createdUser == null){
//           return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
//       }
//       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }

}