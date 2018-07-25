package com.capgemini.UserProfileAndRanking.Availability;

import org.springframework.beans.factory.annotation.Autowired;

public class AvailabilityService {
	
	private AvailabilityMapper availabilityMapper;
	private AvailabilityDAO availabilityDAO;
	
	@Autowired
	public AvailabilityService(AvailabilityDAO availabilityDAO, 
			AvailabilityMapper availabilityMapper){
		
	}
	
	
	public void addAvailability(AvailabilityDTO availabilityDTO) {
		AvailabilityEntity userAvailability = availabilityMapper.from(availabilityDTO);
		availabilityDAO.add(userAvailability);
	}
	
	public void changeAvailability() {
		
	}
	
	public void suspendAndCommentAvailability() {
		
	}
	
	public void removeAvailability() {
		
	}

}
