package com.capgemini.UserProfileAndRanking.Games;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamesService {
	
	@Autowired
	private GamesDAO gamesDAO; 
	
	public List<GamesEntity> findAllGames() {
		List<GamesEntity> allGames = gamesDAO.showAllGames();
		return allGames;
	}
	
	public void removeGame(long userID, long gameID) {
		gamesDAO.removeGame(userID, gameID);
	}
	
	public void addGame() {
		
	}
	
	public GamesDTO findGame(long id) {
		
		return null;
	}
}


