package com.capgemini.user.profile.and.ranking.games;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.user.profile.and.ranking.userBoardGame.UserBoardGameDAO;

public class GamesDAO {
	
	
	private List<GamesEntity> gamesList = new ArrayList<>();
	private UserBoardGameDAO userBoardGameDAO;
	
	
	public List<GamesEntity> showAllGames() {
		return gamesList;
	}
	
	public void addGame(long userID, long gameID) {
		userBoardGameDAO.add(userID, gameID);
	}
	
	public void removeGame(long userID, long gameID) {
		userBoardGameDAO.removeUserGame(userID, gameID);
	}
	
	public GamesEntity findGameByID(long id) {
		return gamesList.stream().filter(gameByID -> gameByID.getID() == id)
				.findFirst().orElseGet(null);
	}

}
