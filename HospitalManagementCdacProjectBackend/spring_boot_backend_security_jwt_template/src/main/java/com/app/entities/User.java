package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 50, unique=true)
	private String gender;
	private String address;
	
	private LocalDate dob;
	private String email;
	@Column(length = 40, nullable=false)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private RoleType role;
	@Column(length = 50)
	private String mobile;
	@Column(length = 500)
	private String securityQue;
	@Column(length = 50)
	private String securityAns;
	
	private Timestamp createdAt;

	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Employee employee;
	
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Patient patient ;
	
	
	//***************connection to employee 
	public void addEmployee(Employee e) {
		this.employee=e;
		this.employee.setUser(this);
		
	}
	//***************connection to patient 
	public void addPatient(Patient p) {
		this.patient=p;
		this.patient.setUser(this);
		
	}


	
	
	

	
	
	
	
	
}
