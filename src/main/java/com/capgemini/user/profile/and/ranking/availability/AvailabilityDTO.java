package com.capgemini.user.profile.and.ranking.availability;

import com.capgemini.user.profile.and.ranking.enums.DayOfTheWeek;
import com.capgemini.user.profile.and.ranking.enums.Hours;

public class AvailabilityDTO {

	private DayOfTheWeek dayOfTheWeek;
	private Hours hours;
	private long userID;
	private boolean suspended;
	private String comment;

	public AvailabilityDTO() {
		
	}
	
	public AvailabilityDTO(DayOfTheWeek dayOfTheWeek, Hours hours, long userID, boolean suspended, String comment) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.hours = hours;
		this.userID = userID;
		this.suspended = suspended;
		this.comment = comment;
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
	
	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
