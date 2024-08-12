package com.springboot.user_devops.controller;


import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.user_devops.dto.AuthenticationDTO;
import com.springboot.user_devops.dto.AuthenticationResponse;
import com.springboot.user_devops.service.UserService;
import com.springboot.user_devops.util.JwtUtil;

import java.io.IOException;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationDTO authenticationDTO, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
        try {
        	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword()));
    		SecurityContextHolder.getContext().setAuthentication(authentication);
         } catch (BadCredentialsException e) {
        	System.out.println("Taca");
            //throw new BadCredentialsException("Incorrect username or password!");
        	//response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not found!");
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
         }

        final UserDetails userDetails = userService.loadUserByUsername(authenticationDTO.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}