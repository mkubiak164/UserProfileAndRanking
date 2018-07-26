package com.capgemini.user.profile.and.ranking.profile;

public class ProfileMapper implements ProfileMapperInterface {

	@Override
	public ProfileDTO from(ProfileEntity profileEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfileEntity from(ProfileDTO profileDTO) {

		return new ProfileEntity(profileDTO.getId(), profileDTO.getName(), profileDTO.getLastName(),
				profileDTO.getEmail(), profileDTO.getPassword(), profileDTO.getMotto());
	}

	@Override
	public ProfileEntity edit(ProfileEntity profileEntity, ProfileDTO profileDTO) {
		
		profileEntity.setName(profileDTO.getName());
		profileEntity.setLastName(profileDTO.getLastName());
		profileEntity.setEmail(profileDTO.getEmail());
		profileEntity.setPassword(profileDTO.getPassword());
		profileEntity.setMotto(profileDTO.getMotto());
		
		return profileEntity;
	}
	
	

	
	
	
}
