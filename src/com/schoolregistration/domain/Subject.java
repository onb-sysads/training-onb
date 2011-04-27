package com.schoolregistration.domain;

public class Subject {
	
	private int subjectId;
	private String subjectName;
	private String subjectDescription;
	private int subjectTypeId;
	public Subject(int subjectId, String subjectName,
			String subjectDescription, int subjectTypeId) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectDescription = subjectDescription;
		this.subjectTypeId = subjectTypeId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectDescription() {
		return subjectDescription;
	}
	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}
	public int getSubjectTypeId() {
		return subjectTypeId;
	}
	public void setSubjectTypeId(int subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((subjectDescription == null) ? 0 : subjectDescription
						.hashCode());
		result = prime * result + subjectId;
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
		result = prime * result + subjectTypeId;
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
		Subject other = (Subject) obj;
		if (subjectDescription == null) {
			if (other.subjectDescription != null)
				return false;
		} else if (!subjectDescription.equals(other.subjectDescription))
			return false;
		if (subjectId != other.subjectId)
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		if (subjectTypeId != other.subjectTypeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName="
				+ subjectName + ", subjectDescription=" + subjectDescription
				+ ", subjectTypeId=" + subjectTypeId + "]";
	}

	
	

}
