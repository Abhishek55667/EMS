package com.example.EMS.services;
import java.util.List;


import com.example.EMS.model.Employee;
import com.example.EMS.model.Leave;
import com.example.EMS.model.Manager;
import com.example.EMS.repository.EmployeeRepository;
import com.example.EMS.repository.LeaveRepository;
import com.example.EMS.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private LeaveRepository leaveRepository;
	@Autowired
	private ManagerRepository managerRepository;
	
	@Override
	public Leave applyLeaveByEmployee(Leave leave, Long empid) {
		Employee emp = employeeRepository.findById(empid).orElse(null);
		if(emp != null) {
			leave.setEmployee(emp);
			leave.setStatus("PENDING");
			return leaveRepository.save(leave);
		}
		return null;
	}

	@Override
	public List<Leave> viewLeavesByEmployee(Long empid) {
		return leaveRepository.findByEmployeeId(empid);
	}

	@Override
	public List<Leave> viewAllPendingLeaves() {
		return leaveRepository.findByStatus("PENDING");
	}

	@Override
	public Leave applyLeaveByManager(Leave leave, Long managerid) {
		Manager manager = managerRepository.findById(managerid).orElse(null);
		if(manager != null) {
			leave.setManager(manager);
			leave.setStatus("PENDING");
			return leaveRepository.save(leave);
		}
		return null;
	}

	@Override
	public List<Leave> viewLeavesByManager(Long managerid) {
		return leaveRepository.findByManagerId(managerid);
	}

	@Override
	public String updateLeaveStatus(int leaveid, String status) {
		Leave leave = leaveRepository.findById(leaveid).orElse(null);
		if (leave != null) {
			leave.setStatus(status.toUpperCase());
			return "Leave Status Updated to: " + status;
		}
		return "Leave ID not found";
	}

}
