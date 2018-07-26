package com.capgemini.UserProfileAndRanking.UserBoardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.UserProfileAndRanking.Games.GamesEntity;

public class UserBoardGameDAO {

	private List<UserBoardGameEntity> userBoardGamesList = new ArrayList<>();
	private UserBoardGameEntity gameEntity;
	
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
	
	

	
}
