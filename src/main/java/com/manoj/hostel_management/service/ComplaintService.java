package com.manoj.hostel_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manoj.hostel_management.entity.Complaint;
import com.manoj.hostel_management.entity.User;
import com.manoj.hostel_management.repository.ComplaintRepository;
import com.manoj.hostel_management.repository.UserRepository;

@Service
public class ComplaintService {
	
	@Autowired
	private ComplaintRepository complaintRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Complaint raiseComplaint(Long userId, Complaint complaint) {
		
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found"));
		complaint.setUser(user);
		return complaintRepository.save(complaint);
	}

}
