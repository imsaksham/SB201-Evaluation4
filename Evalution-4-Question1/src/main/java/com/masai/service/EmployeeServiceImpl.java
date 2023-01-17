package com.masai.service;

import java.util.List;
import java.util.Optional;

import javax.sound.midi.Soundbank;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.module.Address;
import com.masai.module.Employee;
import com.masai.module.EmployeeDTO;
import com.masai.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee registerEmployee(Employee employee) throws EmployeeException {
		Employee employee1=employeeRepository.save(employee);
		if(employee1==null) {
			throw new EmployeeException("No data found");
		}else {
			return employee1;
		}
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) throws EmployeeException {
	Optional<Employee> optional=employeeRepository.findById(employeeId);
	if(optional.isEmpty()) {
		throw new EmployeeException("No employee data found with id: "+employeeId);
	}else{
		Employee employee=optional.get();
		return employee;
	 }
   }

	@Override
	public Employee loginEmployee(String email, String password) throws EmployeeException {
		Employee employee=employeeRepository.loginEmployeeByPasswordandEmail(email, password);
		if(employee==null) {
			throw new EmployeeException("Please enter correct details to login");
		}else {
			return employee;
		}
	}

	@Override
	
	public Employee updateEmployeePassword(String email, String oldPassword, String newPassword) throws EmployeeException {
	Employee employee=employeeRepository.updateEmployeeByPassword(oldPassword);
	if(employee==null) {
		throw new EmployeeException("Please enter correct password to login");
		
	}else {
		employee.setEmail(email);
		employee.setPassword(newPassword);
		System.out.println(employee);
		employeeRepository.save(employee);
		return employee;
	   }
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
	List<Employee > employees=	employeeRepository.findAll();
	if(employees.isEmpty()) {
		throw new EmployeeException("Data not found");
	}else {
		return employees;
	}

	}

	@Override
	public Employee deleteEmployeeById(Integer employeeId) throws EmployeeException {
		Optional< Employee> optional=employeeRepository.findById(employeeId);
		if(optional.isEmpty()) {
			throw new EmployeeException("Data has not been deleted");
			
		}else {
			Employee employee=optional.get();
			employeeRepository.delete(employee);
			return employee;
		}
			}

	@Override
	public List<Employee> getEmployeeDetailsByAddress(Address address) throws EmployeeException {
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		
		Optional<Employee> optional=employeeRepository.findById(employee.getEmployeeId());
		if(optional.isEmpty()) {
			throw new EmployeeException("Data has not been updated");
		}else {
			Employee employee2=optional.get();
			employee2.setAddress(employee.getAddress());
			employee2.setAge(employee.getAge());
			employee2.setEmail(employee.getEmail());
			employee2.setEmployeeName(employee.getEmployeeName());
			employee2.setMobile(employee.getMobile());
			employee2.setPassword(employee.getPassword());
			employeeRepository.save(employee2);
			return employee2;
		}
			}

	@Override
	public Employee updateEmployeeAddress(Integer employeeId, Address address) throws EmployeeException {
	Optional<Employee> optional=	employeeRepository.findById(employeeId);
	if(optional.isEmpty()) {
		throw new EmployeeException("Data has not been updated");
	}else {
		Employee employee=optional.get();
		employee.setAddress(address);
		employeeRepository.save(employee);
		return employee;
	}
		
	}

	@Override
	public List<Employee> getEmployeesBetweenAge(Integer start_age, Integer end_age) throws EmployeeException {
		return null;
	}

	@Override
	public List<EmployeeDTO> getNameAddressAgeOfAllEmployees() throws EmployeeException {
		return null;
	}

}
