package com.capgemini.user.profile.and.ranking.profile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class ProfileDAO {
	
	private List<ProfileEntity> profileEntities;
	
	public ProfileDAO() {
		ProfileEntity p1 = new ProfileEntity(1, "Andrzej", "Kowalski", "andrzej@poczta.pl", "123", "kasztan");
		profileEntities.add(p1);
		ProfileEntity p2 = new ProfileEntity(2, "Anna", "Nowak", "anowak@mail.com", "abc", "patelnia");
		profileEntities.add(p2);
		
	}
	
	public ProfileEntity giveMeUser(long id) {
		for(ProfileEntity myUser : profileEntities) {
			if (myUser.getId() == id) {
				return myUser;
			}
		}
		return null;
	}
	
	public List<ProfileEntity> findUserByName(String name) {
		List<ProfileEntity> foundUsers = new ArrayList<>();
		for(ProfileEntity currentUser : profileEntities) {
			if (currentUser.getName() == name) {
				foundUsers.add(currentUser);
			}
		}
		return foundUsers;
	}
	
	public List<ProfileEntity> findUserByLastName(String lastName) {
		List<ProfileEntity> foundUsers = new ArrayList<>();
		for(ProfileEntity currentUser : profileEntities) {
			if (currentUser.getLastName() == lastName) {
				foundUsers.add(currentUser);
			}
		}
		return foundUsers;
	}
	
	public List<ProfileEntity> findUserByEmail(String email) {
		List<ProfileEntity> foundUsers = new ArrayList<>();
		for(ProfileEntity currentUser : profileEntities) {
			if (currentUser.getEmail() == email) {
				foundUsers.add(currentUser);
			}
		}
		return foundUsers;
	}
	
	
	public List<ProfileEntity> giveMeAllUsers() {
		return profileEntities;
	}
	
	public void add(ProfileEntity profileEntity) {
		long id = profileEntities.get(profileEntities.size()-1).getId();
		profileEntity.setId(id+1);
		profileEntities.add(profileEntity);
	}

	public ProfileEntity findUserByEmailAndName(String email, String name) {
		List<ProfileEntity> foundProfiles = profileEntities.stream().filter(p -> p.getEmail().equals(email) && p.getName().equals(name))
				.collect(Collectors.toList());
		return foundProfiles.get(0);
	}
}
