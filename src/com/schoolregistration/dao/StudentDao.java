package com.schoolregistration.dao;

import java.util.Set;

import com.schoolregistration.domain.Student;
import com.schoolregistration.domain.SchoolClass;

public interface StudentDao {
	
	Student getStudent(int studentId) throws DataAccessException;
	void addClassToStudent() throws DataAccessException;
	Set<SchoolClass> getEnrolledClass() throws DataAccessException;
		

}
