package com.app.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Employee;
import com.app.entities.RoleType;
import com.app.entities.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor 
@Getter 
@Setter 
@ToString 
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
	public class EmployeeUserDto {
		
		    private int userId;
			private String firstName;
			private String lastName;
			private String email;
			@JsonProperty(access = Access.WRITE_ONLY)
			private String password;
			private RoleType role;
			private String mobile;
			private String securityQue;
			private String securityAns;
			//to generate the jwt token
			private String token;
	//*********************************************************************
			
			private int empId;
			
			private LocalDate dob;
			
			private LocalDate hireDate;
			private double salary;
			private double doctorCharges;
			private int patientId;//required if role is patient
			private int doctorId;
			
			
	//*********************************************************************
			@JsonProperty(access = Access.WRITE_ONLY)
			public Employee getEmployeeFromData() {
				Employee employee= new Employee(dob, hireDate, salary);
				User user =new User(firstName, lastName, email, password, role, mobile, securityQue, securityAns);
				employee.setUser(user);
				return employee;
				
			}
	//*********************************************************************
			public static List<EmployeeUserDto> createEmployee(List<Employee> employees){
				List<EmployeeUserDto> employeeDetails= new ArrayList<EmployeeUserDto>();
				for(Employee e:employees) {
					EmployeeUserDto emp= new EmployeeUserDto();
					emp.setFirstName(e.getUser().getFirstName());
					emp.setLastName(e.getUser().getLastName());
					emp.setRole(e.getUser().getRole());
					emp.setMobile(e.getUser().getMobile());
					emp.setEmpId(e.getId());
					emp.setDob(e.getDob());
					emp.setHireDate(e.getHireDate());
					emp.setSalary(e.getSalary());
					emp.setEmail(e.getUser().getEmail());
					
					employeeDetails.add(emp);
				}
				
				return employeeDetails;
			}
			
	//***************************************************************************
			
			public static EmployeeUserDto createUser(User user) {
				
					
					EmployeeUserDto validUser=new  EmployeeUserDto();
					validUser.setEmail(user.getEmail());
					validUser.setRole(user.getRole());
					validUser.setPassword(user.getPassword());
					if(user.getRole().equals("patient")) {
						validUser.setPatientId(user.getPatient().getId());
					}
					if(user.getRole().equals("doctor"))
						validUser.setDoctorId(user.getEmployee().getDoctor().getId());
					return validUser;
				}

	///*****************************to update an employee*********************
			public static Employee updateEmployee(int userId,EmployeeUserDto userData) {
				Employee updatedEmployee=new Employee();
				User corruspondingUser=new User();
				corruspondingUser.setId(userId);
				corruspondingUser.setFirstName(userData.getFirstName());
				corruspondingUser.setLastName(userData.getLastName());
				corruspondingUser.setRole(userData.getRole());
				updatedEmployee.setId(userData.getEmpId());
				
				return updatedEmployee;
				
			}
			


}
