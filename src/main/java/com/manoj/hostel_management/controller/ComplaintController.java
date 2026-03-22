package com.manoj.hostel_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.hostel_management.entity.Complaint;
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

}
