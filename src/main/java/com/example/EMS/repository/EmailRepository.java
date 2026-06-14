package com.example.EMS.repository;

import com.example.EMS.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmailRepository extends JpaRepository<Email, Integer>{

}
