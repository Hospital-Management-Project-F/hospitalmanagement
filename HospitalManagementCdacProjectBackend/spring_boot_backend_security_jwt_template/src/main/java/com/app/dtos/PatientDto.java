package com.app.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;

import com.app.entities.BloodType;
import com.app.entities.Patient;
import com.app.entities.RoleType;
import com.app.entities.WardType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonInclude(value=Include.NON_NULL)
	public class PatientDto {
		
		    private int userId;
			private String firstName;
			private String lastName;
			private String email;
			private String gender;
			private String address;
			@JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
			private String password;
			private RoleType role;
			private String mobile;
			private String securityQue;
			private String securityAns;
			
	//********************Patient extra Details*************************************************
			
			private int patientId;
		
			private LocalDate dob;
			private LocalDate dateOfAdmission;
			private int wardId;
			private int doctorId;
			private BloodType bloodGroup;
			private String prescription;
			private int bedAlloted;
			private Boolean paymentStatus;
			private String patientProblem;
			private String doctorFirstName;
			private String doctorLastName;
			private WardType type;
			
			private String doctorMobileNo;
			//medicine assigned list
			
			
			
			public static List<PatientDto> createPatient(List<Patient> employees){
				List<PatientDto> employeeDetails= new ArrayList<PatientDto>();
				for(Patient p:employees) {
					PatientDto createdPatient= new PatientDto();
					createdPatient.setFirstName(p.getUser().getFirstName());
					createdPatient.setLastName(p.getUser().getLastName());
					createdPatient.setRole(p.getUser().getRole());
					createdPatient.setDoctorMobileNo(p.getUser().getMobile());
					//createdPatient.setDob(p.getDob());
					createdPatient.setEmail(p.getUser().getEmail());
					createdPatient.setPatientId(p.getId());
					createdPatient.setUserId(p.getUser().getId());
					createdPatient.setWardId(p.getWard().getId());
					createdPatient.setDoctorId(p.getDoctor().getId());
					createdPatient.setDateOfAdmission(p.getDateOfAdmission());
					createdPatient.setBloodGroup(p.getBloodGroup());
					if(p.getPrescription()==null) {
						createdPatient.setPrescription("doctor will prescribe you");//to see if prescription is empty or not 
					}else {
						createdPatient.setPrescription(p.getPrescription());
					}

					createdPatient.setBedAlloted(p.getBedAlloted());
					createdPatient.setPaymentStatus(p.getPaymentStatus());
					createdPatient.setPatientProblem(p.getPatientProblem());
					createdPatient.setDoctorFirstName(p.getDoctor().getEmployee().getUser().getFirstName());
					createdPatient.setDoctorLastName(p.getDoctor().getEmployee().getUser().getLastName());
					createdPatient.setPrescription(p.getPrescription());
					createdPatient.setType(p.getWard().getType());
					createdPatient.setDoctorMobileNo(p.getUser().getMobile());
					employeeDetails.add(createdPatient);
				}
				
				return employeeDetails;
			}
			//=====================================patient to send to front end
			
			public static PatientDto getByIdPatient(Patient p) {
				PatientDto createdPatient=new PatientDto();
				createdPatient.setFirstName(p.getUser().getFirstName());
				createdPatient.setLastName(p.getUser().getLastName());
				createdPatient.setRole(p.getUser().getRole());
				createdPatient.setMobile(p.getUser().getMobile());
				//createdPatient.setDob(p.getDob());
				createdPatient.setEmail(p.getUser().getEmail());
				createdPatient.setPatientId(p.getId());
				createdPatient.setUserId(p.getUser().getId());
				createdPatient.setWardId(p.getWard().getId());
				createdPatient.setDoctorId(p.getDoctor().getId());
				createdPatient.setDateOfAdmission(p.getDateOfAdmission());
				createdPatient.setBloodGroup(p.getBloodGroup());
				createdPatient.setPrescription(p.getPrescription());
				createdPatient.setBedAlloted(p.getBedAlloted());
				createdPatient.setPaymentStatus(p.getPaymentStatus());
				createdPatient.setPatientProblem(p.getPatientProblem());
				createdPatient.setDoctorFirstName(p.getDoctor().getEmployee().getUser().getFirstName());
				createdPatient.setDoctorLastName(p.getDoctor().getEmployee().getUser().getLastName());
				createdPatient.setPrescription(p.getPrescription());
				createdPatient.setType(p.getWard().getType());
				createdPatient.setDoctorMobileNo(p.getDoctor().getEmployee().getUser().getMobile());
				
				return createdPatient;
				
			}
			
			
			
	//***********************************patients of doctor**********************************
			public static List<PatientDto> createPatientsOfDoctor(List<Patient> employees,int doctorId){
				List<PatientDto> employeeDetails= new ArrayList<PatientDto>();
				for(Patient p:employees) {
					if(p.getDoctor().getId()==doctorId) {
						
						PatientDto createdPatient= new PatientDto();
						createdPatient.setFirstName(p.getUser().getFirstName());
						createdPatient.setLastName(p.getUser().getLastName());
						createdPatient.setRole(p.getUser().getRole());
						createdPatient.setMobile(p.getUser().getMobile());
						//createdPatient.setDob(p.getDob());
						createdPatient.setEmail(p.getUser().getEmail());
						createdPatient.setPatientId(p.getId());
						createdPatient.setUserId(p.getUser().getId());
						createdPatient.setWardId(p.getWard().getId());
						createdPatient.setDoctorId(p.getDoctor().getId());
						createdPatient.setDateOfAdmission(p.getDateOfAdmission());
						createdPatient.setBloodGroup(p.getBloodGroup());
						if(p.getPrescription()==null) {
							createdPatient.setPrescription("doctor will prescribe you");//to see if prescription is empty or not 
						}else {
							createdPatient.setPrescription(p.getPrescription());
						}

						createdPatient.setBedAlloted(p.getBedAlloted());
						createdPatient.setPaymentStatus(p.getPaymentStatus());
						createdPatient.setPatientProblem(p.getPatientProblem());
						createdPatient.setDoctorFirstName(p.getDoctor().getEmployee().getUser().getFirstName());
						createdPatient.setDoctorLastName(p.getDoctor().getEmployee().getUser().getLastName());
						createdPatient.setPrescription(p.getPrescription());
						createdPatient.setType(p.getWard().getType());
						createdPatient.setDoctorMobileNo(p.getUser().getMobile());
						employeeDetails.add(createdPatient);
					}

					}
								
				return employeeDetails;
			}
				
			
	//*********************************************************************
			
			
	//***************************************************************************
			
			
	///*****************************to update an employee*********************
			
}		

	



