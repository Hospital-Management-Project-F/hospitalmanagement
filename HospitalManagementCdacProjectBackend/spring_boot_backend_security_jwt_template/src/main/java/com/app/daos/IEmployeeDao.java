package com.app.daos;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Appointment;
import com.app.entities.Employee;

public interface IEmployeeDao extends JpaRepository<Employee, Long>{

	
	
	@Modifying
	@Query(value="insert into employees values(:id,:userId,:dob,:hireDate,:salary)",nativeQuery = true)
	int insertIntoEmployeesTable(@Param("id") int id,@Param("userId") int userId,@Param("dob") LocalDate dob,@Param("hireDate")LocalDate hireDate,@Param("salary") double salary);
	
	@Query(value="select id from employees where user_id=(select id from users where email= :email)",nativeQuery = true)
	int getEmpIdByEmail(@Param("email")String email);
}
