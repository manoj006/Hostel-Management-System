package com.manoj.hostel_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manoj.hostel_management.entity.Complaint;
import com.manoj.hostel_management.entity.User;
import com.manoj.hostel_management.enums.ComplaintStatus;

public interface ComplaintRepository extends JpaRepository<Complaint, Long>{
	
	List<Complaint> findByUser(User user);
	
	// Filter by status
	List<Complaint> findByStatus(ComplaintStatus status);
	
	//Dashboard counts
	long countByStatus(ComplaintStatus status);
	

}
