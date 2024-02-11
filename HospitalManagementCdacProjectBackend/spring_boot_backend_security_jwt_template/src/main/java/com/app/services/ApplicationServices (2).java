package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.IAppointmentDao;
import com.app.daos.IEmployeeDao;
import com.app.daos.IUserDao;
import com.app.daos.IWardDao;
import com.app.dtos.AppointmentDto;
import com.app.entities.Appointment;



@Service @Transactional
public class ApplicationServices {
	@Autowired
	IUserDao userDao;
	@Autowired
	IEmployeeDao employeeDao;
	@Autowired
	IWardDao wardDao;
	@Autowired 
	IAppointmentDao visitsDao;
	
	public int addVisit(AppointmentDto visitData)  {
		return visitsDao.insertIntoDoctorVisitsTable(0, visitData.getPatientId(), visitData.getDoctorId(), 0);
	}
	public void increaseVisitCount(AppointmentDto visitData) {
		
		Appointment visit=visitsDao.getVisitsByPatIdAndDoctorId(visitData.getPatientId(),visitData.getDoctorId());
		visit.setVisits(visit.getVisits()+1);
		visitsDao.save(visit);
	}
	
	
	
	

}