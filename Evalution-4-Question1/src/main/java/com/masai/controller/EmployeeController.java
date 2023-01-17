package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.internal.constraintvalidators.bv.notempty.NotEmptyValidatorForArraysOfLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmployeeException;
import com.masai.module.Address;
import com.masai.module.Employee;
import com.masai.service.EmployeeService;



@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee( @Valid @RequestBody Employee employee) throws EmployeeException{
		Employee employee1=employeeService.registerEmployee(employee);
		return new ResponseEntity<Employee>(employee1,HttpStatus.CREATED);
		
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) throws EmployeeException{
		Employee employee= employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	
	@GetMapping("/employee/{email}/{password}")
	public ResponseEntity<Employee> loginInEmployee(@PathVariable String email,@PathVariable String password) throws EmployeeException{
	  Employee employee=employeeService.loginEmployee(email, password);
	  return new ResponseEntity<Employee>(employee,HttpStatus.ACCEPTED);
	}

	@PutMapping("/employee/{email}/{oldpassword}/{newpassword}")
	public ResponseEntity<Employee> updateEmployeeByPassword(@PathVariable String email,@PathVariable String oldpassword,@PathVariable String newpassword) throws EmployeeException{
		Employee employee=employeeService.updateEmployeePassword(email, oldpassword, newpassword);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	@GetMapping("/employee/allemployee")
	public ResponseEntity<List<Employee>> findAllEmployee() throws EmployeeException{
		List<Employee> employeeList=employeeService.getAllEmployeeDetails();
		return new ResponseEntity<List<Employee>> (employeeList,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Integer id) throws EmployeeException{
		Employee employee=employeeService.deleteEmployeeById(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	@PutMapping("/employee/newemployee")
	public ResponseEntity<Employee> updateNewEmployee(@Valid @RequestBody Employee employee ) throws EmployeeException{
		Employee employee2=employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
	}
	@PutMapping("employeebyaddress/{id}")
	public ResponseEntity<Employee> updateEmployeeofaddress(@PathVariable Integer id,@Valid @RequestBody Address address) throws EmployeeException{
	Employee employee=	employeeService.updateEmployeeAddress(id, address);
	return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
}

