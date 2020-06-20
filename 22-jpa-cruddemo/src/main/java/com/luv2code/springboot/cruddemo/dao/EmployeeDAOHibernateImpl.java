package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define field for entitymanager
	
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	//@Transactional  remove @Transactional from DAO we will add a Service to hanlde @Transactional  
	public List<Employee> findAll() {
		
		//get the current hibernate session
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery=currentSession.createQuery("from Employee",Employee.class);
		
		//execute query and get result list
		
		List<Employee> employees=theQuery.getResultList();
		//return the results
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		//get the current hibernate session
		Session  currentSession=entityManager.unwrap(Session.class);
		
		//get the employee
		Employee theEmployee =currentSession.get(Employee.class,theId);
		
		//return the Employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		//get the current hibernate session
				Session  currentSession=entityManager.unwrap(Session.class);
		//save the employee
				currentSession.saveOrUpdate(theEmployee);
				
		
	}

	@Override
	public void deleteById(int theId) {
		//get the current hibernate session
		Session  currentSession=entityManager.unwrap(Session.class);
		
		//delete object with primary key
		
		Query theQuery=currentSession.createQuery("delete from employee where id=:employeeId");
		theQuery.setParameter("employeeId",theId);
		theQuery.executeUpdate();
		
	}

	

}
