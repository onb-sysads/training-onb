package com.schoolregistration.dao;

import java.util.Set;

public interface UserTypeDao  {
	
	public Set<String> getUserTypes() throws DataAccessException;
	public int getUserTypeIdByName(String name) throws DataAccessException;
}
