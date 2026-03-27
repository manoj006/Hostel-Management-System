package com.manoj.hostel_management.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manoj.hostel_management.entity.Complaint;
import com.manoj.hostel_management.entity.User;
import com.manoj.hostel_management.enums.ComplaintStatus;
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
	
	public List<Complaint> getAllComplaints() {
		return complaintRepository.findAll();
	}
	
	public List<Complaint> getComplaintsByUser(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found"));
		return complaintRepository.findByUser(user);
				
	}
	
	public Complaint updateStatus(Long id, String status) {
		Complaint complaint = complaintRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("complaint not found"));
		complaint.setStatus(ComplaintStatus.valueOf(status));
		return complaintRepository.save(complaint);
	}
	
	// Filter by status
	public List<Complaint> getComplaintsByStatus(ComplaintStatus status) {
		return complaintRepository.findByStatus(status);
	}
	
	// Dashboard API
	public Map<String, Long> getDashboard() {
		Map<String, Long> data = new HashMap<>();
		
		data.put("OPEN", complaintRepository.countByStatus(ComplaintStatus.OPEN));
		data.put("IN_PROGRESS", complaintRepository.countByStatus(ComplaintStatus.IN_PROGRESS));
		data.put("RESOLVED", complaintRepository.countByStatus(ComplaintStatus.RESOLVED));
		
		return data;
	}

}
