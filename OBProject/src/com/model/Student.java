package com.model;

public class Student {
	
	private int studentId;
	private String studentFirstName;
	private String studentLastName;
	private String studentAddress;
	private String studentContact;
	
	public Student() {}

	public Student(int studentId, String studentFirstName,
			String studentLastName, String studentAddress, String studentContact) {
		
		this.studentId = studentId;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentAddress = studentAddress;
		this.studentContact = studentContact;
		
	}

	public int getStudentId() {
		return studentId;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public String getStudentContact() {
		return studentContact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((studentAddress == null) ? 0 : studentAddress.hashCode());
		result = prime * result
				+ ((studentContact == null) ? 0 : studentContact.hashCode());
		result = prime
				* result
				+ ((studentFirstName == null) ? 0 : studentFirstName.hashCode());
		result = prime * result + studentId;
		result = prime * result
				+ ((studentLastName == null) ? 0 : studentLastName.hashCode());
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
		Student other = (Student) obj;
		if (studentAddress == null) {
			if (other.studentAddress != null)
				return false;
		} else if (!studentAddress.equals(other.studentAddress))
			return false;
		if (studentContact == null) {
			if (other.studentContact != null)
				return false;
		} else if (!studentContact.equals(other.studentContact))
			return false;
		if (studentFirstName == null) {
			if (other.studentFirstName != null)
				return false;
		} else if (!studentFirstName.equals(other.studentFirstName))
			return false;
		if (studentId != other.studentId)
			return false;
		if (studentLastName == null) {
			if (other.studentLastName != null)
				return false;
		} else if (!studentLastName.equals(other.studentLastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentAddress=" + studentAddress
				+ ", studentContact=" + studentContact + ", studentFirstName="
				+ studentFirstName + ", studentId=" + studentId
				+ ", studentLastName=" + studentLastName + "]";
	}
	
	
	
	

}
