package com.manoj.hostel_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manoj.hostel_management.entity.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long>{

}
