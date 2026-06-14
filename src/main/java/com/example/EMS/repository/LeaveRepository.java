package com.example.EMS.repository;

import java.util.List;

import com.example.EMS.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {
	
	public List<Leave> findByEmployeeId(Long eid);
	public List<Leave> findByStatus(String status);
	public List<Leave> findByManagerId(Long mid);

}
