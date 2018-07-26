package com.capgemini.user.profile.and.ranking.availability;

import com.capgemini.user.profile.and.ranking.enums.DayOfTheWeek;
import com.capgemini.user.profile.and.ranking.enums.Hours;

public class AvailabilityEntity {

	private DayOfTheWeek dayOfTheWeek;
	private Hours hours;
	private long userID;
	private boolean suspended;
	private String comment;
	

	public AvailabilityEntity(DayOfTheWeek dayOfTheWeek, Hours hours, boolean suspended) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.hours = hours;
		this.suspended = suspended;
	}
	
	public AvailabilityEntity(DayOfTheWeek dayOfTheWeek, Hours hours, long id, boolean suspended, String comment) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.hours = hours;
		this.userID = id;
		this.suspended = suspended;
		this.comment = comment;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayOfTheWeek == null) ? 0 : dayOfTheWeek.hashCode());
		result = prime * result + ((hours == null) ? 0 : hours.hashCode());
		result = prime * result + (int) (userID ^ (userID >>> 32));
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
		AvailabilityEntity other = (AvailabilityEntity) obj;
		if (dayOfTheWeek != other.dayOfTheWeek)
			return false;
		if (hours != other.hours)
			return false;
		return true;
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
