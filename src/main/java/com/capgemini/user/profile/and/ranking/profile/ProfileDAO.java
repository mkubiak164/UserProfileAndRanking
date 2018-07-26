package com.capgemini.user.profile.and.ranking.profile;

import java.util.List;

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
	
	public List<ProfileEntity> giveMeAllUsers() {
		return profileEntities;
	}
	
	public void add(ProfileEntity profileEntity) {
		long id = profileEntities.get(profileEntities.size()-1).getId();
		profileEntity.setId(id+1);
		profileEntities.add(profileEntity);
	}

}
