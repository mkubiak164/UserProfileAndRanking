package com.capgemini.user.profile.and.ranking.profile;

public interface ProfileMapperInterface {

	public ProfileDTO from(ProfileEntity profileEntity);
	
	public ProfileEntity from(ProfileDTO profileDTO);
	
	public ProfileEntity edit(ProfileEntity profileEntity, ProfileDTO profileDTO);
	
	
	
}
