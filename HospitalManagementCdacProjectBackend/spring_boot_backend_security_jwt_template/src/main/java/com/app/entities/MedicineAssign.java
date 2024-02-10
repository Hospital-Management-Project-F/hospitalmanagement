package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="medicine_assign")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineAssign extends BaseEntity{

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "patient_id")
	private Patient patient ;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "medicine_id")
	private Medicine medicine ;
	
	@Column(length = 4000)
   private String prescription;
	
	private int medicineQty;
}