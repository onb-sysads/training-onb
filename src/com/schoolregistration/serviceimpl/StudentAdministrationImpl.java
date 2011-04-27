package com.schoolregistration.serviceimpl;

import com.com.schoolregistration.services.StudentAdministration;
import com.com.schoolregistration.services.ServiceException;
import com.schoolregistration.dao.DataAccessException;
import com.schoolregistration.dao.StudentDao;
import com.schoolregistration.dao.impl.JDBCStudentImpl;
import com.schoolregistration.domain.Student;

public class StudentAdministrationImpl implements StudentAdministration{
	
	StudentDao studentDAO = new JDBCStudentImpl();
	
	public void setClassDAO(StudentDao studDAO) {
		this.studentDAO = studDAO;
	}
	
	public  StudentDao getStudentDAO() {
		return this.studentDAO;
	}

	@Override
	public Student getStudent(int userId) throws ServiceException {
		
		Student stud = null;
		
		try {
			stud = studentDAO.getStudent(userId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stud;
	}
	
	public static void main(String[] args) throws ServiceException {
		StudentAdministrationImpl std = new StudentAdministrationImpl();
		Student d = std.getStudent(1);
		
		System.out.println(d.toString());
		
	}
	
	
	
	
}
