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
@Setter
@Getter
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
	public User(String firstName, String lastName, String email, String password, RoleType role, String mobile,
			String securityQue, String securityAns) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.securityQue = securityQue;
		this.securityAns = securityAns;
	}


	//***********created for testing purpose
//	public User(int id, String firstName) {
//		super();
//		this.id = id;
//		this.firstName = firstName;
//	}
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
//		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+this.getRole().toUpperCase()));
//
//		return grantedAuthorities;
//		
//	}
//	@Override
//	public String getUsername() {
//		
//		return email;
//	}
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	


	
	
	

	
	
	
	
	
}
