package com.capgemini.UserProfileAndRanking.Availability;

import com.capgemini.UserProfileAndRanking.Enums.DayOfTheWeek;
import com.capgemini.UserProfileAndRanking.Enums.Hours;

public class AvailabilityDTO {

	private DayOfTheWeek dayOfTheWeek;
	private Hours hours;
	// private long id;
	
	
	public AvailabilityDTO() {
		
	}
	
	public AvailabilityDTO(DayOfTheWeek dayOfTheWeek, Hours hours) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.hours = hours;
	}
	
	public DayOfTheWeek getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	public Hours getHours() {
		return hours;
	}

	public void setHours(Hours hours) {
		this.hours = hours;
	}
	
	
}
