package com.masai.module;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	@NotNull
	@Size(min=3, max=10)
	private String employeeName;
	@NotNull
	@Embedded
	private Address address;
	@NotNull
	@Min(value = 18, message = "Age should not be less than 18")
	private Integer age;
	@NotNull
	@Email
	@Column(unique=true)
	private String email;
	@NotNull
	private String mobile;
	@NotNull
	@Size(min=8, max=150)
	private String password;
	
	public Employee(Integer employeeId, String employeeName, Address address, Integer age, String email, String mobile,
			String password) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.address = address;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	
	public Employee() {
		super();
	}

	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", address=" + address
				+ ", age=" + age + ", email=" + email + ", mobile=" + mobile + ", password=" + password + "]";
	}
	
}
