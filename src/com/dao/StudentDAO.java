package com.dao;

import java.util.Set;

import com.model.Student;;

public interface StudentDAO {
	
	Student getStudent() throws DataAccessException;

	void addClassToStudent() throws DataAccessException;

	Set<Class> getEnrolledClasses() throws DataAccessException;

	Set<Class> getAvailableClasses() throws DataAccessException;
	
}
