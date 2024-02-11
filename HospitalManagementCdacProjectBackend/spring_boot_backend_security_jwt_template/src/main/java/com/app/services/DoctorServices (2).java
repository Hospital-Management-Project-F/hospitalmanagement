package com.app.services;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.IDoctorDao;
import com.app.daos.IEmployeeDao;
import com.app.daos.IPatientDao;
import com.app.daos.IUserDao;
import com.app.dtos.DoctorDto;
import com.app.dtos.PatientDto;
import com.app.entities.Doctor;


	@Service 
	@Transactional
	public class DoctorServices {
		@Autowired
		IUserDao userDao;
		@Autowired
		IEmployeeDao employeeDao;
		@Autowired
		IDoctorDao doctorDao;
		@Autowired
		IPatientDao patientDao;
		
		public List<DoctorDto> getAllDoctors() {
			List<Doctor> doctors=doctorDao.findAll();
			List<DoctorDto> doctorDetail=createDoctorsList(doctors);
			
			return doctorDetail;
			
		}

		

		public void updatePatientDetails(PatientDto patientData) throws NoSuchPatientFoundException  {
			int updateCount;
			if(patientDao.existsById(patientData.getPatientId()))
			 updateCount=patientDao.updatePatientPrescription(patientData.getPrescription(),patientData.getPatId());
			else
			throw new NoSuchPatientFoundException("patient  with id "+patientData.getPatientId()+" does not exists");
		}
		
		

	}