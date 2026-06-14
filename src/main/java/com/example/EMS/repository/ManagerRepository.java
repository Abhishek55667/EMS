package com.example.EMS.repository;

import java.util.Optional;

import com.example.EMS.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{
	public Manager findByUsernameAndPassword(String username, String password);
	public Manager findByUsername(String username);
	public Manager findByEmail(String email);
	
	public Optional<Manager> FindByEmail(String email);
}
