package com.capgemini.UserProfileAndRanking.Profile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.UserProfileAndRanking.Games.GamesDAO;
import com.capgemini.UserProfileAndRanking.Games.GamesEntity;
import com.capgemini.UserProfileAndRanking.UserBoardGame.UserBoardGameDAO;
import com.capgemini.UserProfileAndRanking.UserBoardGame.UserBoardGameEntity;

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
		ProfileEntity userProfile = profileDAO.giveMieUser(id);
		if(userProfile != null) {
			return profileMapper.from(userProfile);
		}
		//  co zwracamy jeżeli index nie istnieje?
		return null;
	}
	
	public void editProfile(long id, ProfileDTO profileDTO) {
		ProfileEntity profileEntity = profileDAO.giveMieUser(id);
		ProfileEntity editedEntity = profileMapper.edit(profileEntity, profileDTO);
		profileDAO.add(editedEntity);
	}
	
	public List<GamesEntity> showUserGames(long id) {
		List<GamesEntity> games = new ArrayList<>();
		ProfileEntity wantedUser = profileDAO.giveMieUser(id);
		if(wantedUser != null){
			List<UserBoardGameEntity> wantedUserGames = userBoardGameDAO.findUserBoardGames(id);
			for (UserBoardGameEntity userGame : wantedUserGames) {
				games.add(gamesDAO.findGameByID(userGame.getGameID()));
			}
		}
		return games;
	}
	
	public List<ProfileEntity> findAllUsers() {
		List<ProfileEntity> allUsers = profileDAO.giveMieAllUsers();
		return allUsers;
	}
	
	

}
