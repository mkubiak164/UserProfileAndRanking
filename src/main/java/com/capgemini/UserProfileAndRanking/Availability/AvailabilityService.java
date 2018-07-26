package com.capgemini.UserProfileAndRanking.Availability;

import org.springframework.beans.factory.annotation.Autowired;

public class AvailabilityService {
	
	private AvailabilityMapper availabilityMapper;
	private AvailabilityDAO availabilityDAO;
	
	@Autowired
	public AvailabilityService(AvailabilityDAO availabilityDAO, AvailabilityMapper availabilityMapper){
	 // TODO this this
	}
	
	
	public void addAvailability(AvailabilityDTO availabilityDTO) {
		AvailabilityEntity userAvailability = availabilityMapper.from(availabilityDTO);
		availabilityDAO.add(userAvailability);
	}
	
	public void editAvailability() {
		// tak jak z edycją profilu na wejsciu nowe dane, na podst id stare dane, przep. wartości
	}
	
	public void suspendAndCommentAvailability() {
		// id usera, dzień i godzina, dodatkowe pole w encji "Suspended" t/f  , flaga na true, pole comment
	}
	
	public void removeAvailability() {
		// id usera, dzien i godzina zmapować na encje, szukać encji i usunąć z listy REMOVE
	}
	
	public void showSimilarAvailabilityUsers(long id) {
		// wejscie moje id 
	}

}
