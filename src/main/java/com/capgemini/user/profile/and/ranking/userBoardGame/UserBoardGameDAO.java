package com.capgemini.user.profile.and.ranking.userBoardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.user.profile.and.ranking.games.GamesDAO;
import com.capgemini.user.profile.and.ranking.games.GamesEntity;

@Repository
public class UserBoardGameDAO {

	private List<UserBoardGameEntity> userBoardGamesList = new ArrayList<>();
	private GamesDAO gamesDAO;
	
	@Autowired
	public UserBoardGameDAO(List<UserBoardGameEntity> userBoardGamesList, GamesDAO gamesDAO) {
		super();
		this.userBoardGamesList = userBoardGamesList;
		this.gamesDAO = gamesDAO;
	}

	
	public UserBoardGameDAO(List<UserBoardGameEntity> userBoardGamesList) {
		this.userBoardGamesList = userBoardGamesList;
	}

	public List<UserBoardGameEntity> findUserBoardGames(long idUser) {
		
		return userBoardGamesList.stream()
			.filter(userGame -> userGame.getUserID() == idUser)
			.collect(Collectors.toList());
	}
	
	public void removeUserGame(long idUser, long idGame) {

		List<UserBoardGameEntity> userBoardGames = findUserBoardGames(idUser);
		UserBoardGameEntity userBoardGameEntity =
				userBoardGames.stream().filter(gameToRemove -> gameToRemove.getGameID() == idGame).findFirst().get();

		userBoardGamesList.remove(userBoardGameEntity);
	}
	
	public void add(long idUser, long idGame){
		GamesEntity gameToAdd = gamesDAO.findGameByID(idGame);
		if(gameToAdd != null){
			UserBoardGameEntity userBoardGameEntity = new UserBoardGameEntity(idUser, idGame);
			userBoardGamesList.add(userBoardGameEntity);
		}
	}

}

