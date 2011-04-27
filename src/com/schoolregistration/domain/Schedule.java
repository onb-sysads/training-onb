package com.schoolregistration.domain;

public class Schedule {
	
	private int scheduleId;
	private DaySchedule daySchedule;
	private TimeSchedule timeSchedule;
	public Schedule(int scheduleId, DaySchedule daySchedule,
			TimeSchedule timeSchedule) {
		super();
		this.scheduleId = scheduleId;
		this.daySchedule = daySchedule;
		this.timeSchedule = timeSchedule;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public DaySchedule getDaySchedule() {
		return daySchedule;
	}
	public void setDaySchedule(DaySchedule daySchedule) {
		this.daySchedule = daySchedule;
	}
	public TimeSchedule getTimeSchedule() {
		return timeSchedule;
	}
	public void setTimeSchedule(TimeSchedule timeSchedule) {
		this.timeSchedule = timeSchedule;
	}
	@Override
	public String toString() {
		return "Schedule [daySchedule=" + daySchedule + ", scheduleId="
				+ scheduleId + ", timeSchedule=" + timeSchedule + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((daySchedule == null) ? 0 : daySchedule.hashCode());
		result = prime * result + scheduleId;
		result = prime * result
				+ ((timeSchedule == null) ? 0 : timeSchedule.hashCode());
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
		Schedule other = (Schedule) obj;
		if (daySchedule == null) {
			if (other.daySchedule != null)
				return false;
		} else if (!daySchedule.equals(other.daySchedule))
			return false;
		if (scheduleId != other.scheduleId)
			return false;
		if (timeSchedule == null) {
			if (other.timeSchedule != null)
				return false;
		} else if (!timeSchedule.equals(other.timeSchedule))
			return false;
		return true;
	}
	
	

}
