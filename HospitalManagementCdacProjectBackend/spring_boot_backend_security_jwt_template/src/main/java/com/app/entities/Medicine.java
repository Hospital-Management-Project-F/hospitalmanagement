package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
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
@Table(name="medicines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicine extends BaseEntity{

	private String name;
	private Double price;
	
	@OneToMany(mappedBy = "medicine",cascade = CascadeType.PERSIST)
	private List<MedicineAssign> mappedMedicines;

	//to set the medicine id in assigned medicine
		public void addAssignedMedicine(MedicineAssign medicineAssigned) {
			medicineAssigned.setMedicine(this);
			mappedMedicines.add(medicineAssigned);
			
		}

		public int getId() {
			// TODO Auto-generated method stub
			return id;
		}
}
