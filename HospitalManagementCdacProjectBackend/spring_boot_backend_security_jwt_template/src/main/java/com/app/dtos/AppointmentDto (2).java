package com.app.dtos;

import lombok.Data;

@Data
public class AppointmentDto {
	
	private long visitId;
	private long patientId;
	private long doctorId;
	private int visits;

}
