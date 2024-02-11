package com.app.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.sunbeam.dtos.WardDataBackinBean.*;

import com.app.daos.IMedicineAssignDao;
import com.app.dtos.MedicineAssignDto;
import com.sunbeam.custom_exception.NoSuchMedicineExistsException;
import com.sunbeam.daos.IDoctorDao;
import com.sunbeam.daos.IEmployeeDao;
import com.sunbeam.daos.IMedicineAssignedDao;
import com.sunbeam.daos.IMedicineDao;
import com.sunbeam.daos.IUserDao;
import com.sunbeam.daos.IWardDao;
import com.sunbeam.dtos.DoctorDataBackinBean;
import com.sunbeam.dtos.MedicineAssignedDataBackinBean;
import com.sunbeam.dtos.WardDataBackinBean;
import com.sunbeam.entities.Ward;
import com.sunbeam.entities.User;

@Service @Transactional
public class MedicineAssignServices {
	@Autowired
	com.app.daos.IDoctorDao userDao;
	@Autowired
	com.app.daos.IEmployeeDao employeeDao;
	@Autowired
	com.app.daos.IWardDao wardDao;
	@Autowired
	com.app.daos.IMedicineDao medicineAssingedDao;
	@Autowired
	IMedicineAssignDao medicineDao;
	
	public void addMedicineToPatient(MedicineAssignDto medicineData) throws NoSuchMedicineExistsException {
		
			medicineAssingedDao.addIntoMedicineAssign(medicineData.getPatId(), medicineData.getMedicineId(), medicineData.getMedicinePrescription(), medicineData.getMedicineQty());
		
		
		
	}
	
	public void removeMedicineOfPatient(int medicineAssignId) {
		medicineAssingedDao.deleteById(medicineAssignId);
	}
	
	
	
	

}
