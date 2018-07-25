package com.capgemini.UserProfileAndRanking.Availability;

import java.util.ArrayList;
import java.util.List;



public class AvailabilityDAO {

	private List<AvailabilityEntity> availabilityList = new ArrayList<>();
	
	public AvailabilityEntity showAvailability(long id) {
		for(AvailabilityEntity userAvailability : availabilityList) {
			if(userAvailability.getId() == id) {
				return userAvailability;
			}
		}
		return null;
	}
	// STREAM 
	
	
	public void add(AvailabilityEntity availabilityEntity) {
		
	}
	
	public List<AvailabilityEntity> getAvailabilityList() {
		return availabilityList;
	}

	public void setAvailabilityList(List<AvailabilityEntity> availabilityList) {
		this.availabilityList = availabilityList;
	}
	
	
	
}
