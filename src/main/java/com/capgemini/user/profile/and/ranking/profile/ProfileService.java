package com.capgemini.user.profile.and.ranking.profile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.capgemini.user.profile.and.ranking.games.GamesDAO;
import com.capgemini.user.profile.and.ranking.games.GamesEntity;
import com.capgemini.user.profile.and.ranking.userBoardGame.UserBoardGameDAO;
import com.capgemini.user.profile.and.ranking.userBoardGame.UserBoardGameEntity;

@Service
public class ProfileService {

	private ProfileDAO profileDAO;
	private ProfileMapper profileMapper;
	private UserBoardGameDAO userBoardGameDAO;
	private GamesDAO gamesDAO;
	
	@Autowired
	public ProfileService(ProfileDAO profileDAO, ProfileMapper profileMapper,
			UserBoardGameDAO userBoardGameDAO, GamesDAO gamesDAO) {
		this.profileDAO = profileDAO;
		this.profileMapper = profileMapper;
		this.userBoardGameDAO = userBoardGameDAO;
		this.gamesDAO = gamesDAO;
	}

	
	public void addProfile(ProfileDTO profileDTO) {
		ProfileEntity userProfile = profileMapper.from(profileDTO);
		profileDAO.add(userProfile);
	}
	
	public ProfileDTO showProfile(long id) {
		ProfileEntity userProfile = profileDAO.giveMeUser(id);
		if(userProfile == null) {
			return null;
		}
		return profileMapper.from(userProfile);
	}
	
	public void editProfile(long id, ProfileDTO profileDTO) {
		ProfileEntity profileEntity = profileDAO.giveMeUser(id);
		ProfileEntity editedEntity = profileMapper.edit(profileEntity, profileDTO);
		profileDAO.add(editedEntity);
	}
	
	public List<GamesEntity> showUserGames(long id) {
		List<GamesEntity> games = new ArrayList<>();
		ProfileEntity wantedUser = profileDAO.giveMeUser(id);
		if(wantedUser != null){
			List<UserBoardGameEntity> wantedUserGames = userBoardGameDAO.findUserBoardGames(id);
			for (UserBoardGameEntity userGame : wantedUserGames) {
				games.add(gamesDAO.findGameByID(userGame.getGameID()));
			}
		}
		return games;
	}
	
	public List<ProfileEntity> findAllUsers() {
		List<ProfileEntity> allUsers = profileDAO.giveMeAllUsers();
		return allUsers;
	}
	
	public List<ProfileEntity> findByName(String name) {
		List<ProfileEntity> foundUsers = profileDAO.findUserByName(name);
		return foundUsers;
	}
	
	public List<ProfileEntity> findByLastName(String lastName) {
		List<ProfileEntity> foundUsers = profileDAO.findUserByLastName(lastName);
		return foundUsers;
	}
	
	public List<ProfileEntity> findByEmail(String email) {
		List<ProfileEntity> foundUsers = profileDAO.findUserByEmail(email);
		return foundUsers;
	}


	public ProfileDTO searchByEmailName(String email, String name) {
		return profileMapper.from(profileDAO.findUserByEmailAndName(email, name));
	}
}
