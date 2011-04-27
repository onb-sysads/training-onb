package com.schoolregistration.domain;

public class DaySchedule {
	
	private int dayScheduleId;
	private String days;
	public DaySchedule(int dayScheduleId, String days) {
		super();
		this.dayScheduleId = dayScheduleId;
		this.days = days;
	}
	public int getDayScheduleId() {
		return dayScheduleId;
	}
	public void setDayScheduleId(int dayScheduleId) {
		this.dayScheduleId = dayScheduleId;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "DaySchedule [dayScheduleId=" + dayScheduleId + ", days=" + days
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dayScheduleId;
		result = prime * result + ((days == null) ? 0 : days.hashCode());
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
		DaySchedule other = (DaySchedule) obj;
		if (dayScheduleId != other.dayScheduleId)
			return false;
		if (days == null) {
			if (other.days != null)
				return false;
		} else if (!days.equals(other.days))
			return false;
		return true;
	}
	
	

}
