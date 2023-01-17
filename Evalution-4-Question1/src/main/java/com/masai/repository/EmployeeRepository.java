package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.masai.module.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
	@Query("select e from Employee e where e.email=?1 and e.password=?2")
	 Employee loginEmployeeByPasswordandEmail(String email,String password);
     
	@Query("select e from Employee e where e.password=?1")
	 Employee updateEmployeeByPassword(String oldPassword);
}
