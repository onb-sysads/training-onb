package com.schoolregistration.dao;

import java.util.Set;

import com.schoolregistration.domain.Teacher;

public interface TeacherDao {
	
	Set<Teacher> getAvailableTeachers() throws DataAccessException;

}
