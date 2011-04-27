package com.schoolregistration.domain;

public class TimeSchedule {
	
	private int timeScheduleId;
	private String time;
	public TimeSchedule(int timeScheduleId, String time) {
		super();
		this.timeScheduleId = timeScheduleId;
		this.time = time;
	}
	public int getTimeScheduleId() {
		return timeScheduleId;
	}
	public void setTimeScheduleId(int timeScheduleId) {
		this.timeScheduleId = timeScheduleId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "TimeSchedule [time=" + time + ", timeScheduleId="
				+ timeScheduleId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + timeScheduleId;
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
		TimeSchedule other = (TimeSchedule) obj;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (timeScheduleId != other.timeScheduleId)
			return false;
		return true;
	}
	
	

}
