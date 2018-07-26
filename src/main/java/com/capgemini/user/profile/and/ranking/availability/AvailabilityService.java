package com.capgemini.user.profile.and.ranking.availability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.user.profile.and.ranking.profile.ProfileDTO;
import com.capgemini.user.profile.and.ranking.profile.ProfileEntity;
import com.capgemini.user.profile.and.ranking.profile.ProfileMapper;
import com.capgemini.user.profile.and.ranking.profile.ProfileService;

public class AvailabilityService {

	private AvailabilityMapper availabilityMapper;
	private AvailabilityDAO availabilityDAO;
	private ProfileService profileService;
	private ProfileMapper profileMapper;


	@Autowired
	public AvailabilityService(AvailabilityDAO availabilityDAO, AvailabilityMapper availabilityMapper,
			ProfileService profileService, ProfileMapper profileMapper) {
		this.availabilityDAO = availabilityDAO;
		this.availabilityMapper = availabilityMapper;
		this.profileService = profileService;
		this.profileMapper = profileMapper;
	}

	public void addAvailability(AvailabilityDTO availabilityDTO) {
		AvailabilityEntity userAvailability = availabilityMapper.from(availabilityDTO);
		availabilityDAO.add(userAvailability);
	}

	public void editAvailability(long id, AvailabilityDTO currentAvailability, AvailabilityDTO futureAvailability) {

		List<AvailabilityEntity> userAvailabilities = availabilityDAO.showAvailability(id);

		AvailabilityEntity currentAvailabilityEntity = availabilityMapper.from(currentAvailability);
			// konwersja z DTO na encję
		
		for (AvailabilityEntity currentUserAvailability : userAvailabilities) {
			if (currentUserAvailability.equals(currentAvailabilityEntity)) {
				// wygenerowane equals do porównywania wszystkich 2 pól (hour, day)
				
				AvailabilityEntity editedEntity = 
						availabilityMapper.edit(currentUserAvailability, futureAvailability);
				// po znalezieniu przepisanie wartości z future do encji 
				
				availabilityDAO.remove(currentUserAvailability);
				availabilityDAO.add(editedEntity);
				// wywalenie starego, dodanie nowego
			}
		}
		
	}

	public void suspendAndCommentAvailability(long userID, AvailabilityDTO availabilityDTO) {
		
		List<AvailabilityEntity> userAvailabilities = availabilityDAO.showAvailability(userID);

		AvailabilityEntity currentAvailabilityEntity = availabilityMapper.from(availabilityDTO);
			// konwersja z DTO na encję
		
		for (AvailabilityEntity currentUserAvailability : userAvailabilities) {
			if (currentUserAvailability.equals(currentAvailabilityEntity)) {
				// wygenerowane equals do porównywania wszystkich 2 pól (hour, day)
				
				currentUserAvailability.setSuspended(true);
				currentUserAvailability.setComment(availabilityDTO.getComment());
			}
		}
	}

	public void removeAvailability(long userID, AvailabilityDTO currentAvailability) {

		List<AvailabilityEntity> userAvailability = availabilityDAO.showAvailability(userID);
		AvailabilityEntity currentAvailabilityEntity = availabilityMapper.from(currentAvailability);
		
		AvailabilityEntity entityToRemove = null;
		for (AvailabilityEntity userEntity : userAvailability) {
			if (userEntity.equals(currentAvailabilityEntity)) {
				entityToRemove = userEntity;
			}
		}
		if (entityToRemove != null) {
			availabilityDAO.remove(entityToRemove);
		}
	}

	public List<AvailabilityEntity> showAvailability(long id) {
		return availabilityDAO.showAvailability(id);
	}
	

	public List<ProfileEntity> showSimilarAvailabilityUsers(long id) {
		
		List<ProfileEntity> allUsers = profileService.findAllUsers();
		List<ProfileEntity> similarUsers = new ArrayList<>();
		
		ProfileDTO myUser = profileService.showProfile(id);
		List<AvailabilityEntity> myAvailabilities = showAvailability(myUser.getId());
		
		for(ProfileEntity userAvailabilities : allUsers){
			ProfileDTO currentUser = profileService.showProfile(userAvailabilities.getId());
			List<AvailabilityEntity> currentUserAvailabilities = showAvailability(currentUser.getId());
			if(!Collections.disjoint(myAvailabilities, currentUserAvailabilities)) {
				ProfileEntity similarUserProfile = profileMapper.from(currentUser);
				similarUsers.add(similarUserProfile);
			}
		}
		return similarUsers;
	}

}
