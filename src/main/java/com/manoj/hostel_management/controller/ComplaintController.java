package com.manoj.hostel_management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.hostel_management.entity.Complaint;
import com.manoj.hostel_management.enums.ComplaintStatus;
import com.manoj.hostel_management.service.ComplaintService;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {
	
	@Autowired
	private ComplaintService complaintService;
	
	@PostMapping("/raise/{userId}")
	public Complaint raiseComplaint(@PathVariable Long userId, @RequestBody Complaint complaint) {
		return complaintService.raiseComplaint(userId, complaint);
	}
	
	@GetMapping
	public List<Complaint> getAllComplaints() {
		return complaintService.getAllComplaints();
	}
	
	@GetMapping("/user/{userId}")
	public List<Complaint> getComplaintByUser(@PathVariable Long userId) {
		return complaintService.getComplaintsByUser(userId);
	}
	
	@PutMapping("/{id}/status")
	public Complaint updateStatus(@PathVariable Long id, @RequestParam String status) {
		return complaintService.updateStatus(id, status);
	}
	
	// Filter by status
	@GetMapping("/status")
	public List<Complaint> getComplaintsByStatus(@RequestParam ComplaintStatus status) {
		return complaintService.getComplaintsByStatus(status);
	}
	
	// Dashboard API
	@GetMapping("/dashboard")
	public Map<String, Long> getDashboard() {
		return complaintService.getDashboard();
	}
	
	@GetMapping("/test")
	public String test() {
		return "working..";
	}

}
