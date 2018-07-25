package com.capgemini.UserProfileAndRanking.Games;

import java.util.ArrayList;
import java.util.List;

public class GamesDAO {
	
	private List<GamesEntity> gamesList = new ArrayList<>();
	
	public List<GamesEntity> showAllGames() {
		return gamesList;
	}
	
	public void addGame() {
		
	}
	
	public void removeGame() {
		
	}
	
	public GamesEntity findGameByID(long id) {
		return gamesList.stream().filter(gameByID -> gameByID.getID() == id)
				.findFirst().orElseGet(null);
	}

}
