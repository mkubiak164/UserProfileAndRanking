package com.capgemini.UserProfileAndRanking.Availability;

public class AvailabilityMapper {

	public AvailabilityMapper() {
		
	}
	
	public AvailabilityEntity from(AvailabilityDTO availabilityDTO) {
		return new AvailabilityEntity( availabilityDTO.getDayOfTheWeek(), 
				availabilityDTO.getHours(), availabilityDTO.getUserID());  
	}
	
}
