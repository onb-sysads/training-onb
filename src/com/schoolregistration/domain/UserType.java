package com.schoolregistration.domain;

public class UserType {
	
	private int userTypeId;
	private String userTypeName;
	
	public UserType(int userTypeId, String userTypeName) {
		super();
		this.userTypeId = userTypeId;
		this.userTypeName = userTypeName;
	}
	
	public int getUserTypeId() {
		return userTypeId;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userTypeId;
		result = prime * result
				+ ((userTypeName == null) ? 0 : userTypeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserType other = (UserType) obj;
		if (userTypeId != other.userTypeId)
			return false;
		if (userTypeName == null) {
			if (other.userTypeName != null)
				return false;
		} else if (!userTypeName.equals(other.userTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserType [userTypeId=" + userTypeId + ", userTypeName="
				+ userTypeName + "]";
	}

	
	
	
	
}
