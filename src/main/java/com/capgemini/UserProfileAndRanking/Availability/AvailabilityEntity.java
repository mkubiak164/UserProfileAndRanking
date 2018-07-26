package com.capgemini.UserProfileAndRanking.Availability;

import com.capgemini.UserProfileAndRanking.Enums.DayOfTheWeek;
import com.capgemini.UserProfileAndRanking.Enums.Hours;

public class AvailabilityEntity {

	private DayOfTheWeek dayOfTheWeek;
	private Hours hours;
	private long userID;
	

	public AvailabilityEntity(DayOfTheWeek dayOfTheWeek, Hours hours) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.hours = hours;
	}
	
	public AvailabilityEntity(DayOfTheWeek dayOfTheWeek, Hours hours, long id) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.hours = hours;
		this.userID = id;
	}
	
	public long getId() {
		return userID;
	}

	public void setId(long id) {
		this.userID = id;
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
