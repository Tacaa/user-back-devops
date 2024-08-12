package com.springboot.user_devops.service;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.springboot.user_devops.model.User;
import com.springboot.user_devops.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{
	
	private UserRepository repository;
	
	public User getUserById(Long id) {
		Optional<User> user = this.repository.findById(id);
		if(!user.isEmpty()) {
			return user.get();
		}
		return null;
	}

	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //Write Logic to get the user from the DB
        User user = repository.findFirstByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not found",null);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
	 
}
