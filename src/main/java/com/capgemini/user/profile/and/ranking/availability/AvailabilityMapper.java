package com.capgemini.user.profile.and.ranking.availability;

public class AvailabilityMapper {

	public AvailabilityMapper() {
		
	}
	
	public AvailabilityEntity from(AvailabilityDTO availabilityDTO) {
		return new AvailabilityEntity( availabilityDTO.getDayOfTheWeek(), 
				availabilityDTO.getHours(), availabilityDTO.getUserID(), 
				availabilityDTO.isSuspended(), availabilityDTO.getComment());  
	}
	
	public AvailabilityEntity edit(AvailabilityEntity availabilityEntity, AvailabilityDTO availabilityDTO){
		
		availabilityEntity.setDayOfTheWeek(availabilityDTO.getDayOfTheWeek());
		availabilityEntity.setHours(availabilityDTO.getHours());
		
		return availabilityEntity;
	}
	
	
	
	
	
	
	
	
}
