package com.employee.application.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.application.entity.Employee;
import com.employee.application.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String getListOfEmployee(Model model){
		List<Employee> employee = employeeService.getListOfAllEmployee();
		model.addAttribute("employee", employee);
		return "index";	
	}
	
	@GetMapping("/addUser")
	public String addUser() {
		return "addUser";
	}
	
	@GetMapping("/updateUser/{id}")
	public String updateUser(@PathVariable Long id, Model model) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee.get());
		return "updateUser";
	}
	
	@GetMapping("/viewUser/{id}")
	public String viewUser(@PathVariable Long id, Model model) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee.get());
		return "viewUser";
	}
	
	@PostMapping("/submitUser")
	public String addUser(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute Employee employee, Model model) {
		employeeService.updateEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		System.out.println("id === "+id);
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}

}
