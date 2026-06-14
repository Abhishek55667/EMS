package com.example.EMS.repository;


import com.example.EMS.model.Employee;
import com.example.EMS.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	// Search functionality
	public List<Employee> findByNameContainingIgnoreCase(String name);

	public Employee findByUsernameAndPassword(String username, String password);

	public Employee findByUsername(String username);
	public Employee findByEmail(String email);

	public Optional<Manager> FindByEmail(String email);
	
}
