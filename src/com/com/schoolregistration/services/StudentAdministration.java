package com.com.schoolregistration.services;

import com.schoolregistration.domain.Student;


public interface StudentAdministration {
	
	public Student getStudent(int userId) throws ServiceException;
	

}
