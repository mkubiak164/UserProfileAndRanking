package com.capgemini.user.profile.and.ranking.availability;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class AvailabilityDAO {

	private List<AvailabilityEntity> availabilityList = new ArrayList<>();
	
	public List<AvailabilityEntity> showAvailability(long id) {
		
		return availabilityList.stream()
				.filter(userAvailability -> userAvailability.getId() == id)
				.collect(Collectors.toList());
	}
	
	public void add(AvailabilityEntity availabilityEntity) {
		availabilityList.add(availabilityEntity);
	}
	
	public void remove(AvailabilityEntity availabilityEntity) {
		availabilityList.remove(availabilityEntity);
	}
	
	
	
	public List<AvailabilityEntity> getAvailabilityList() {
		return availabilityList;
	}

	public void setAvailabilityList(List<AvailabilityEntity> availabilityList) {
		this.availabilityList = availabilityList;
	}
	
	
	
}
