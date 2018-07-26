package com.capgemini.UserProfileAndRanking.Availability;

import com.capgemini.UserProfileAndRanking.Enums.DayOfTheWeek;
import com.capgemini.UserProfileAndRanking.Enums.Hours;

public class AvailabilityDTO {

	private DayOfTheWeek dayOfTheWeek;
	private Hours hours;
	private long userID;

	public AvailabilityDTO() {
		
	}
	
	public AvailabilityDTO(DayOfTheWeek dayOfTheWeek, Hours hours, long userID) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.hours = hours;
		this.userID = userID;
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
	
	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}
}
