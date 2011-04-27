package com.schoolregistration.dao;

import java.util.Set;

import com.schoolregistration.domain.Subject;

public interface SubjectDao {
	
	Set <Subject> getAvailableSubjects() throws DataAccessException;

}
