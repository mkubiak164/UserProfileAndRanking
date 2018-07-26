package com.capgemini.user.profile.and.ranking.userBoardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.user.profile.and.ranking.games.GamesDAO;
import com.capgemini.user.profile.and.ranking.games.GamesEntity;
import com.capgemini.user.profile.and.ranking.games.GamesService;

public class UserBoardGameDAO {

	private List<UserBoardGameEntity> userBoardGamesList = new ArrayList<>();
	private UserBoardGameEntity gameEntity;
	private GamesDAO gamesDAO;
	private GamesService gamesService;
	
	public List<UserBoardGameEntity> findUserBoardGames(long idUser) {
		
		return userBoardGamesList.stream()
			.filter(userGame -> userGame.getUserID() == idUser)
			.collect(Collectors.toList());
	}
	
	public void removeUserGame(long idUser, long idGame) {
		
		findUserBoardGames(idUser);
		gameEntity = userBoardGamesList.stream()
			.filter(gameToRemove-> gameToRemove.getGameID() == idGame).findFirst();
		userBoardGamesList.remove(gameEntity);
	}
	
	public void add(long idUser, long idGame){
		
		GamesEntity gameToAdd = gamesDAO.findGameByID(idGame);
		if(gameToAdd == null){
			gamesService.addGame();
			gamesDAO.addGame(idUser, idGame);
		}
		gamesDAO.addGame(idUser, idGame);	
	}

}
