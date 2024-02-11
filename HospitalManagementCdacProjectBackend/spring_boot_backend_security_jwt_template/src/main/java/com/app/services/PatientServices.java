package com.app.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.IPatientDao;
import com.app.dtos.MedicineAssignDto;
import com.app.dtos.PatientDto;
import com.app.entities.Doctor;
import com.app.entities.MedicineAssign;
import com.app.entities.Patient;

import static com.sunbeam.dtos.PatientDataBacking.*;
import static com.sunbeam.dtos.MedicineAssignedDataBackinBean.*;
import static com.sunbeam.dtos.ChargesCalculationBeanPatient.*;

@Service @Transactional
public class PatientServices {
	@Autowired
	IUserDao userDao;
	@Autowired
	IEmployeeDao employeeDao;
	@Autowired
	IPatientDao patientDao;
	@Autowired
	IDoctorDao doctorDao;
	@Autowired
	IDoctorVisitDao visitsDao;
	
	@Autowired
	IWardDao wardDao;
	
	public int addPatient(PatientDto patientDetails) throws PatientAlreadyExistsException {
		if(!userDao.existsByEmail(patientDetails.getEmail())) {
			userDao.insertIntoUsers(0, patientDetails.getFirstName(), patientDetails.getLastName(), patientDetails.getEmail(), patientDetails.getPassword(), patientDetails.getCellNo(), patientDetails.getRole(), patientDetails.getSecurityQuestion(), patientDetails.getSecurityAnswer());
			User user=userDao.findByEmail(patientDetails.getEmail());
			int updateCount=patientDao.insertIntoPatients(0, user.getId(),patientDetails.getDoctorId() , patientDetails.getWardId(), patientDetails.getDateOfAdmission(), patientDetails.getBloodGroup(), patientDetails.getDob(), patientDetails.getPrescription(), patientDetails.getBedAlloted(), patientDetails.getPaymentStatus(), patientDetails.getPatientProblem());
			Patient patient=patientDao.findByUserId(user.getId());
			visitsDao.insertIntoDoctorVisitsTable(0, patient.getId(), patientDetails.getDoctorId(),0);
			return updateCount;
		}else {
			throw new PatientAlreadyExistsException("patient with email = "+patientDetails.getEmail()+" exists!!!");
			
		}
		
		
	}
	
	public List<PatientDto> getAllPatients(){
		List<Patient> patients=patientDao.findAll();
		List<PatientDto> patientList=createPatient(patients);
		return patientList;
		
	}
	
	public patientDao getPatientById(int id) throws NoSuchPatientFoundException {
		if(patientDao.existsById(id)) {
			Patient patient=patientDao.getById(id);
			patientDao patientDetailsToSend=getByIdPatient(patient);
			return patientDetailsToSend;
		}else {
			throw new NoSuchPatientFoundException("patient with id = "+id+" does not exists!!!");
		}
		
		
				
	}
	//get patients medicines by patient id
	public List<MedicineAssignDto> getMedicineByPatId(int id) {
		Patient patient=patientDao.getById(id);
		List<MedicineAssign> medicines=patient.getMedicines();
		List<MedicineAssignDto> medicineToSend=createMedicineListForPatient(medicines);
		return medicineToSend;
		
				
	}
	
	//update patient details
	public void updatePatientDetails(PatientDto patientDetails) throws NoSuchPatientFoundException {
		
		if(patientDao.existsById(patientDetails.getPatientId())) {
			Patient updatePatient = patientDao.getById(patientDetails.getPatientId());
			//to add to visit table
			
				Appointment initVisit=visitsDao.getVisitsByPatIdAndDoctorId(patientDetails.getPatientId(), patientDetails.getDoctorId());
				System.out.println("------------------>initvisit"+initVisit);
				if(initVisit==null) {
					visitsDao.insertIntoDoctorVisitsTable(0, patientDetails.getPatientId(), patientDetails.getDoctorId(), 0);
				}
			Ward updateWard=wardDao.getById(patientDetails.getWardId());//got corrusponding ward by ward Id
			updateWard.addPatient(updatePatient);//added patient in ward list
			updatePatient.setWard(updateWard);//new ward set in patient
			//======================================================================
			
			Doctor updatedDoctor=doctorDao.getById(patientDetails.getDoctorId());//got new doctor by id 
			
			
			
			updatedDoctor.addPatient(updatePatient);//patient added in doctor list 
			updatePatient.setDoctor(updatedDoctor);//doctor added to patient list
			
			updatePatient.getUser().setFirstName(patientDetails.getFirstName());
			updatePatient.getUser().setLastName(patientDetails.getLastName());
			updatePatient.getUser().setMobile(patientDetails.getMobile());
			
			updatePatient.setDob(patientDetails.getDob());
			updatePatient.setBedAlloted(patientDetails.getBedAlloted());
			updatePatient.setBloodGroup(patientDetails.getBloodGroup());
			//=======================================
			//update visits
			Patient savedPatient = patientDao.save(updatePatient);
			
			
		}else {
			throw new NoSuchPatientFoundException("patient with id = "+patientDetails.getPatientId()+" does not exists!!!");
		}
		
	}
	
	public int removePatientById(int id) throws NoSuchPatientFoundException {
		if(patientDao.existsById(id)) {
			patientDao.deleteById(id);
			return 1;
		}else {
			throw new NoSuchPatientFoundException("patient with id = "+id+" does not exists!!!");
		}
		
	}
	
//	public ChargesCalculationBeanPatient calculateChargesByPatId(int patId) {
//		ChargesCalculationBeanPatient patientCharges=new ChargesCalculationBeanPatient();
//		int daysStayed = patientDao.calculateDaysOfStayOfPatient(patId);
//		Patient patient=patientDao.getById(patId);
//		patientCharges=calculateCharges(patient, daysStayed);
//		return patientCharges;
//	}
	
	public void updatePaymentStatusByPatId(PatientDto patientData) throws NoSuchPatientFoundException {
		if(patientDao.existsById(patientData.getPatientId())) {
			Patient patient=patientDao.getById(patientData.getPatientId());
			patient.setPaymentStatus(patientData.getPaymentStatus());
			patientDao.save(patient);
		}else {
			throw new NoSuchPatientFoundException("patient with id = "+patientData.getPatientId()+" does not exists!!!");
		}
		
	}
	//check if bedalloted exits
	public Boolean checkIfBedAvailable(PatientDto bedData) {
		
		return patientDao.existsByBedAllotedAndWardId(bedData.getBedAlloted(),bedData.getWardId()); 
	}

	public List<PatientDto> getPatientsOfDocter(int id) {
		List<Patient> patients=patientDao.findAll();
		List<PatientDto> patientList=createPatientsOfDoctor(patients,id);
		return patientList;
		
	}
	
	
	
}