package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	//load employee data 
	
	private List<Employee> theEmployee;
	
	@PostConstruct
	private void loadData() {
		
		//create employees

		Employee emp1=new Employee(1,"Leslie","Andrews","Leslie@gamil.com");
		Employee emp2=new Employee(2,"Emma","Henry","ema@gamil.com");
		Employee emp3=new Employee(3,"Avani","Gupta","avani@gamil.com");
		
		//create the list
		theEmployee =new ArrayList<>();
		
		//add to the list
		theEmployee.add(emp1);
		theEmployee.add(emp2);
		theEmployee.add(emp3);
		
	}
	
	//add mapping for "/list"
	
	@GetMapping("/list")
	public String lsitEmployees(Model theModel) {
		//add to  the spring model
		theModel.addAttribute("employees",theEmployee);
		return "list-employees";
	}
}
