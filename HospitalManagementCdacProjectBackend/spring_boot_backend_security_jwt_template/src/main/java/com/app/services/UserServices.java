package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.app.Usercontroller;
import com.app.daos.IEmployeeDao;
import com.app.daos.IUserDao;
import com.app.dtos.EmployeeUserDto;
import com.app.entities.User;

@Service @Transactional
public class UserServices {

	@Autowired
	IUserDao userDao;
	@Autowired
	IEmployeeDao employeeDao;
	
	public List<User> findAllUsers() {
		return userDao.findAll();
	}
	
	public User findUserById(long userId) {
		return userDao.findById(userId).orElseThrow();
				//getById(userId);
			
	}
	
	public User findUserByEmail(String email) {
		return userDao.findByEmail(email);
		
	}
	//****************get user by email and password*********************
		public EmployeeUserDto getUserByEmailAndPassword(EmployeeUserDto userData) {
			EmployeeUserDto userCreated=new EmployeeUserDto();
			User validUser=userDao.findByEmail(userData.getEmail());
			if(validUser!=null) 
				return userCreated.createUser(validUser);
			return null;
			
		
		}

//	private EmployeeUserDto createUser(User validUser) {
//			// TODO Auto-generated method stub
//			return null;
//		}

		//*********************check if email is unique************
		public Boolean checkIfEmailExists(EmployeeUserDto userData) {
			return userDao.existsByEmail(userData.getEmail());
		}

		public Boolean checkByEmailAndSecurity(EmployeeUserDto useData) {
			User user=userDao.findByEmail(useData.getEmail());
			if(user.getSecurityAns().equals(useData.getSecurityAns())) {
				return true;
			}else {
				return false;
			}
		}

		public Boolean updatePassword(EmployeeUserDto useData) {
			User user=userDao.findByEmail(useData.getEmail());
			if(user.getSecurityAns().equals(useData.getSecurityAns())) {
				user.setPassword(useData.getPassword());
				User updatedReturnUser=userDao.save(user);
				if(updatedReturnUser != null)
				return true;
				
			}
			return false;}

		
		
		
//		public User save(User u) {
//			return IUserDao.save(u);
//		public Book save(Book b) {
//			return bookDao.save(b);
//		}
//			
//		}

//		public static User save(User u) {
//			
//			return userDao.save(u);
//		}
			
			
		}
	



