package com.capgemini.UserProfileAndRanking.Availability;

import com.capgemini.UserProfileAndRanking.Enums.DayOfTheWeek;
import com.capgemini.UserProfileAndRanking.Enums.Hours;

public class AvailabilityEntity {

	private DayOfTheWeek dayOfTheWeek;
	private Hours hours;
	private long id;
	

	public AvailabilityEntity(DayOfTheWeek dayOfTheWeek, Hours hours) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.hours = hours;
	}
	
	public AvailabilityEntity(DayOfTheWeek dayOfTheWeek, Hours hours, long id) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.hours = hours;
		this.id = id;
	}
	
	/*public AvailabilityEntity(AvailabilityDTO availabilityDTO) {
		this.dayOfTheWeek = availabilityDTO.getDayOfTheWeek();
		this.hours = availabilityDTO.getHours();
	}*/
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
