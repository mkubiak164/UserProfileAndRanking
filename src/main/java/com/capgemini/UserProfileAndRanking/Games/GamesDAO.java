package com.capgemini.UserProfileAndRanking.Games;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.UserProfileAndRanking.UserBoardGame.UserBoardGameDAO;

public class GamesDAO {
	
	
	private List<GamesEntity> gamesList = new ArrayList<>();
	private UserBoardGameDAO userBoardGameDAO;
	
	
	public List<GamesEntity> showAllGames() {
		return gamesList;
	}
	
	public void addGame() {
		
	}
	
	public void removeGame(long userID, long gameID) {
		userBoardGameDAO.removeUserGame(userID, gameID);
	}
	
	public GamesEntity findGameByID(long id) {
		return gamesList.stream().filter(gameByID -> gameByID.getID() == id)
				.findFirst().orElseGet(null);
	}

}
