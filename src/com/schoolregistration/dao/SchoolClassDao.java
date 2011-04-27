package com.schoolregistration.dao;

import java.util.Set;

import com.schoolregistration.domain.SchoolClass;

public interface SchoolClassDao {
	
	void addClass(SchoolClass klass) throws DataAccessException;
	Set <SchoolClass> getAvailableClasses() throws DataAccessException;

}
