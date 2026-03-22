package com.manoj.hostel_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manoj.hostel_management.entity.User;
import com.manoj.hostel_management.enums.Role;
import com.manoj.hostel_management.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User Register(User user) {
		user.setRole(Role.RESIDENT);
		return userRepository.save(user);
	}
}
