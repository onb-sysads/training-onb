package com.schoolregistration.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import com.com.schoolregistration.services.ServiceException;
import com.com.schoolregistration.services.UserTypeAdministration;
import com.schoolregistration.dao.DataAccessException;
import com.schoolregistration.dao.UserTypeDao;
import com.schoolregistration.dao.impl.JDBCUserTypeImpl;

public class UserTypeAdministrationImpl implements UserTypeAdministration {
	
	UserTypeDao userTypeDAO = new JDBCUserTypeImpl();
	
	public void setUserTypeDAO(UserTypeDao userTypeDao) {
		this.userTypeDAO = userTypeDao;
	}
	
	public UserTypeDao getUserTypeDAO() {
		return this.userTypeDAO;
	}
	
	@Override
	public Set<String> getUserTypes() throws ServiceException {
		Set<String> userTypes = new HashSet<String>();
		try {
			userTypes = userTypeDAO.getUserTypes();
		}
		catch(DataAccessException da) {
			da.printStackTrace();
		}
		return userTypes;
	}
	
	public static void main(String[] args) throws ServiceException {
		UserTypeAdministrationImpl u = new UserTypeAdministrationImpl();
		
		Set<String> se = u.getUserTypes();
		
		for(String x : se) {
			System.out.println(x);
		}
	}

}
