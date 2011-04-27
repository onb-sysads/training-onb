package com.schoolregistration.domain;

public class SchoolClass {
	
	private int classId;
	private Teacher teacher;
	private Subject subject;
	private Schedule schedule;
	
	public SchoolClass(int classId, Teacher teacher, Subject subject,
			Schedule schedule) {
		super();
		this.classId = classId;
		this.teacher = teacher;
		this.subject = subject;
		this.schedule = schedule;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classId;
		result = prime * result
				+ ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
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
		SchoolClass other = (SchoolClass) obj;
		if (classId != other.classId)
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Class [classId=" + classId + ", schedule=" + schedule
				+ ", subject=" + subject + ", teacher=" + teacher + "]";
	}
	
	

}
