package com.example.EMS.services;
import java.util.List;


import com.example.EMS.model.Admin;
import com.example.EMS.model.Duty;
import com.example.EMS.model.Employee;
import com.example.EMS.model.Manager;
import com.example.EMS.repository.AdminRepository;
import com.example.EMS.repository.DutyRepository;
import com.example.EMS.repository.EmployeeRepository;
import com.example.EMS.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;



public class DutyServiceImpl implements DutyService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private DutyRepository dutyRepository;
	@Autowired
	private ManagerRepository managerRepository;
	
	
	@Override
	public Duty assignDutyByAdminToEmployee(Duty duty, Long empid, int adminid) {
		Employee emp = employeeRepository.findById(empid).orElse(null);
		Admin admin = adminRepository.findById(adminid).orElse(null);
		if (emp != null && admin != null) {
			duty.setEmployee(emp);
			duty.setAssingedByAdmin(admin);
			return dutyRepository.save(duty);
		}
		return null;
	}

	@Override
	public Duty assignDutyByAdminToManager(Duty duty, Long managerid, int adminid) {
		Manager manager = managerRepository.findById(managerid).orElse(null);
		Admin admin = adminRepository.findById(adminid).orElse(null);
		if (manager != null && admin != null) {
			duty.setEmployee(null);
			duty.setManager(manager);
			duty.setAssingedByAdmin(admin);
			return dutyRepository.save(duty);
		}
		return null;
	}

	@Override
	public Duty assignDutyByManagerToEmployee(Duty duty, Long empid, Long managerid) {
		Employee emp = employeeRepository.findById(empid).orElse(null);
		Manager manager = managerRepository.findById(managerid).orElse(null);
		if (emp != null && manager != null) {
			duty.setEmployee(emp);
			duty.setAssingedByManager(manager);
			return dutyRepository.save(duty);
		}
		return null;
	}

	@Override
	public List<Duty> viewAllDutiesofEmployee(Long eid) {
		return dutyRepository.findByEmployeeId(eid);
	}

	@Override
	public List<Duty> viewDutiesAssignedByManager(Long managerid) {
		return dutyRepository.findByAssingedByManager(managerid);
	}

	@Override
	public List<Duty> viewDutiesAssignedByAdmin(int adminid) {
		return dutyRepository.findByAssingedByAdmin(adminid);
	}
}
