package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="emps")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity{
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private  User user;
	
	private LocalDate dob;
	
	private LocalDate hireDate; 
	
	private double salary;
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
	private Doctor doctor;

	

	public void addDoctor(Doctor d) {
		doctor=d;
		doctor.setEmployee(this);
	}
	
	

	public Employee(LocalDate dob, LocalDate hireDate, User user, double salary) {
		super();
		this.dob = dob;
		this.hireDate = hireDate;
		this.user = user;
		this.user.setEmployee(this);
		this.salary = salary;
	}
	

	public Employee(LocalDate dob, LocalDate hireDate, double salary) {
		super();
		this.dob = dob;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	
}
