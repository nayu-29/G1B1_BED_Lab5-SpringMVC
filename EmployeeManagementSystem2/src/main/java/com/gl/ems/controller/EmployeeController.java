package com.gl.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ems.service.EmployeeService;
import com.gl.ems.model.Employee;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
  
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/greet")
	public String greet() 
	{
		return "Hello World";
	}
	
	@GetMapping("/demo")
	public Employee test() 
	{
		Employee e1=new Employee(101,"Ruchi","Sinha","ruchi@gmail.com");
		return e1;
	}
	
	@PostMapping("/addemp")
	public Employee addEmployee(@RequestParam("empid") int eid, 
			 	   @RequestParam("empfname") String fname,
			 	  @RequestParam("emplname") String lname,
			 	 @RequestParam("empemail") String email)
	{
		Employee e2=new Employee();
		e2.setId(eid);
		e2.setFname(fname);
		e2.setLname(lname);
		e2.setEmail(email);	
		
		return employeeService.addEmployee(e2);	
		//return ("Record inserted Successfully");
	}
	
	@PostMapping("/addempByJson")
	public Employee addEmployee(@RequestBody Employee e2)
	{
		return employeeService.addEmployee(e2);	
		//return ("Record inserted Successfully");
	}
	
	@GetMapping("/getemp")
	public Employee getEmployee(@RequestParam("id") int id)
	{
	     return employeeService.getEmployee(id);
	}
	
	@GetMapping("/getAllemp")
	public List<Employee> getAllEmployee()
	{
	     return employeeService.getAllEmployee();
	}
	
	@DeleteMapping("/deleteemp")
	public String deleteEmployee(@RequestParam("id") int id)
	{
	     employeeService.deleteEmployee(id);
	     return "Record Deleted";
	}
	
	@PutMapping("/updateemp")
	public Employee updateEmployee(@RequestParam("empid") int eid,
			                       @RequestBody Employee e3)
	{
		return employeeService.updateEmployee(eid,e3);
	}
	
	//---------------
	@GetMapping("/list")
	public String listEmployee(Model theModel)
	{
		List<Employee> listemp=employeeService.getAllEmployee();
		theModel.addAttribute("emplys",listemp);
		return "employee/list-employee";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Employee e1=new Employee();
		theModel.addAttribute("emply",e1);
		return "employee/employee-form";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("emply") Employee ez)
	{
		employeeService.addEmployee(ez);	
		return "redirect:/emp/list";
	}
	
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("emplyId") int eid,
									Model theModel)
	{
		Employee empdb=employeeService.getEmployee(eid);
		theModel.addAttribute("emply",empdb);
		return "employee/employee-form";
	}
	
	@PostMapping("/delete")
	public String deleteMyBook(@RequestParam("emplyId") int id)
	{
		employeeService.deleteEmployee(id);
		return "redirect:/emp/list";
	}
}
