package com.lt.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lt.pma.dao.EmployeeRepository;
import com.lt.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee>employees=empRepo.findAll();
		model.addAttribute("employees",employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
			
		Employee anEmployee = new Employee();
			model.addAttribute("employee",anEmployee);
			
		return "employees/new-employee";
	}
	@PostMapping("/save")
	public String createEmployee(Model model, Employee employee ) {
		empRepo.save(employee);
		return "redirect:/employees/new";
	}
}
