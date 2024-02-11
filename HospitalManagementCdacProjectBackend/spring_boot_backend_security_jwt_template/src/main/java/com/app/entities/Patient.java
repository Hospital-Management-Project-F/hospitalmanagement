package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends BaseEntity{
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="user_id" )
	private User user;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name ="ward_id" )
	private Ward ward;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name ="doctor_id" )
	private Doctor doctor;
	
	private LocalDate dateOfAdmission;
	
	@Enumerated(EnumType.STRING)
	private BloodType bloodGroup;
	private int bedAlloted;
	private boolean paymentStatus;
	@Column(length = 3000)
	private String patientProblem;
//	@Column(length = 5000)
//	private String prescription;
	
	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
	private List<MedicineAssign> medicines;

	private String prescription;

	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
	private List<Appointment> visits;

//-------------------------------------adding patient to the doctor visit list
	public void addVisit(Appointment visit) {
		visit.setPatient(this);
		this.visits.add(visit);
	}
	
	//*********************testing: add all to add into db
	public Patient(User user, Ward ward, Doctor doctor) {
		super();
		this.user = user;
		this.ward = ward;
		this.doctor = doctor;
	}
	public Patient(int id, LocalDate dateOfAdmission, BloodType bloodGroup, String prescription, int bedAlloted,
			Boolean paymentStatus, String patientProblem) {
		super();
		this.id = id;
		this.dateOfAdmission = dateOfAdmission;
		
		this.bloodGroup = bloodGroup;
		this.prescription = prescription;
		this.bedAlloted = bedAlloted;
		this.paymentStatus = paymentStatus;
		this.patientProblem = patientProblem;
	}
	
	//constructor created for testing purpose
	public Patient(int id, String prescription, int bedAlloted) {
		super();
		this.id = id;
		this.prescription = prescription;
		this.bedAlloted = bedAlloted;
	}
	//add medicine to the list ie store patId in medicine table
	public void medicineAssigned(MedicineAssign medicine) {
		medicine.setPatient(this);
		medicines.add(medicine);
	}

	public Boolean getPaymentStatus() {
		// TODO Auto-generated method stub
		return paymentStatus;
	}
	
	
	
	
	

	
}
