package com.employee.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.employee.application.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Modifying
	@Query("update Employee e set e.firstName = ?1, e.lastName = ?2, e.email = ?3 where e.id = ?4")
	void updateUser(String firstname, String lastname, String email, Long userId);
	
}
