package com.app.controllers;


import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.DoctorDto;
import com.app.dtos.PatientDto;
import com.app.services.ApplicationServices;
import com.app.services.DoctorServices;
import com.app.services.PatientServices;


	
	@CrossOrigin("*")
	@RestController @RequestMapping("/api/doctor")
	public class DoctorController  {
		@Autowired
		DoctorServices  doctorServices;
		@Autowired
		ApplicationServices visitService;
		@Autowired
		PatientServices patientService;
		
		
		@GetMapping("/getAllDoctors")@RolesAllowed({"ROLE_DOCTOR","ROLE_RECEPTION"})
		public ResponseEntity<?> getAllPatients(){
			List<DoctorDto> doctors=doctorServices.getAllDoctors();
			
			return Response.success(doctors);
		}
		@RolesAllowed({"ROLE_DOCTOR"})
		@PostMapping("/addPrescription")
		public void updatePatient(@RequestBody PatientDto patientData) {
			
			doctorServices.updatePatientDetails(patientData);
		}
		@RolesAllowed({"ROLE_DOCTOR"})
		@PostMapping("/increaseVisitCount")
		public ResponseEntity<?> increaseVisitCount(@RequestBody DoctorDto visitData) {
			visitService.increaseVisitCount(visitData);
			return Response.success("increamented");
		}
		@RolesAllowed({"ROLE_DOCTOR"})
		@GetMapping("/getPatients/{id}")
		public ResponseEntity<?> getPatientsOfDoctor(@PathVariable int id){
			List<PatientDto> patientList=patientService.getPatientsOfDocter(id);
			return Response.success(patientList);
		}
		
		
		
	}

}