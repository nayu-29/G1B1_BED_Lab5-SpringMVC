package com.gl.ems.service;

import java.util.List;

import com.gl.ems.model.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee e2);
	
	Employee getEmployee(int id);
	
	List<Employee> getAllEmployee();
	
	void deleteEmployee(int id);
	
	Employee updateEmployee(int eid, Employee e3);
}
