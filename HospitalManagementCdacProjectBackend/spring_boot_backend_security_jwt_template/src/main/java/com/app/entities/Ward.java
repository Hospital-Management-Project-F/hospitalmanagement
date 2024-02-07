package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="wards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ward extends BaseEntity{

    private WardType type;
	
	private double charges;
	 
	private double availability;
	private double maxCapacity;
	
	@OneToMany(mappedBy = "ward",cascade = CascadeType.PERSIST)
	private List<Patient> patients;
}
