package com.app.dtos;

import java.util.ArrayList;
import java.util.List;

import com.app.entities.BaseEntity;
import com.app.entities.Doctor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class DoctorDto extends BaseEntity{
	
	private Long doctorId;
	private String firstName;
	private String lastName;
	
	
	public static List<DoctorDto> createDoctorsList(List<Doctor> doctors){
		List<DoctorDto> createDoctorDtoList=new ArrayList<DoctorDto>();
		
		
		for(Doctor doctor:doctors) {
			DoctorDto createDoctorDto=new DoctorDto();
			
			createDoctorDto.setFirstName(doctor.getEmployee().getUser().getFirstName());
			createDoctorDto.setLastName(doctor.getEmployee().getUser().getLastName());
			createDoctorDto.setDoctorId(doctor.getId());
			createDoctorDtoList.add(createDoctorDto);

			
		}
		
		return createDoctorDtoList;

}
}
	
