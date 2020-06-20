package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.cruddemo.entity.Employee;

//@RepositoryRestResource(path="members")---if we want to access the link by usig "members"
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	// no need to write any  code for implementation class
	
}
