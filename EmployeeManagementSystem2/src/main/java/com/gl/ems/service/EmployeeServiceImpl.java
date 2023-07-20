package com.gl.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ems.model.Employee;
import com.gl.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee e2) {
		// TODO Auto-generated method stub
		return employeeRepository.save(e2);
		//return null;
	}

	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	public Employee updateEmployee(int eid, Employee e3) {
		// TODO Auto-generated method stub
		Employee empdb=getEmployee(eid);
		empdb.setFname(e3.getFname());
		empdb.setLname(e3.getLname());
		empdb.setEmail(e3.getEmail());
		return employeeRepository.save(empdb);
	}

	
}
