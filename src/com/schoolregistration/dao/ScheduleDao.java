package com.schoolregistration.dao;

import java.util.Set;

import com.schoolregistration.domain.Schedule;

public interface ScheduleDao {
	
	Set<Schedule> getAvailableSchedules() throws DataAccessException;

}
