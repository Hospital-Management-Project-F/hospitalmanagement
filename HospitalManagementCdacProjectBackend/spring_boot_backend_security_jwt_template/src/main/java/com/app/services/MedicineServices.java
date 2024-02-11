package com.app.services;

import java.util.List;
import static com.sunbeam.dtos.MedicineAssignedDataBackinBean.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.sunbeam.dtos.WardDataBackinBean.*;

import com.app.dtos.MedicineAssignDto;
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
import com.sunbeam.entities.Medicine;
import com.sunbeam.entities.User;

@Service @Transactional
public class MedicineServices {
	@Autowired
	com.app.daos.IUserDao userDao;
	@Autowired
	com.app.daos.IEmployeeDao employeeDao;
	@Autowired
	com.app.daos.IWardDao wardDao;
	@Autowired
	com.app.daos.IMedicineDao medicineDao;
	@Autowired
	com.app.daos.IMedicineDao medicineAssingedDao;
	
	public List<MedicineAssignDto> getAllMedicines(){
		List<com.app.entities.Medicine> medicine=medicineDao.findAll();
		List<MedicineAssignDto> medicinesTosend=createAllMedicineList(medicine);
		return medicinesTosend;
		
	}

	public int addMedicine(MedicineAssignDto medicineData) {
		return  medicineDao.insertIntoMedicineTable(0, medicineData.getMedicineName(), medicineData.getMedicinePrice());
		
	}

	public void removeMedicine(int medicineId) {
		medicineDao.deleteById(medicineId);
		
	}
	
	
	
	
	

}
