package com.employee.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.application.entity.Employee;
import com.employee.application.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get list of all the employees
	public List<Employee> getListOfAllEmployee(){
		return employeeRepository.findAll();
	}
	
	//save or create an employee
	public void saveEmployee(Employee employee){
		employeeRepository.save(employee);
	} 
	
	//to get an employee data 
	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
				
	}
	
	//to update an employee data
	@Transactional
	public void updateEmployee(Employee employee) {
		employeeRepository.updateUser(employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getId());
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
