package com.example.EMS.services;



import com.example.EMS.model.Admin;
import com.example.EMS.model.Employee;
import com.example.EMS.model.Leave;
import com.example.EMS.model.Manager;

import java.util.List;



public interface AdminService {
	
	public Admin checkadminlogin(String username, String password);
	
	public Manager addManager(Manager manager);
	public List<Manager> viewAllManagers();
	public String deleteManager(Long mid);
	public List<Employee> viewAllEmployees();
	public String deleteEmployee(Long eid);
	public long managercount();
	public long employeecount();
	
	public List<Leave> viewAllLeaveApplications();
}