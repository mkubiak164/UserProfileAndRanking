package com.capgemini.user.profile.and.ranking.games;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamesService {
	
	@Autowired
	private GamesDAO gamesDAO; 
	
	private List<GamesEntity> allGames;
	
	public List<GamesEntity> findAllGames() {
		List<GamesEntity> allGames = gamesDAO.showAllGames();
		return allGames;
	}
	
	public void removeGame(long userID, long gameID) {
		gamesDAO.removeGame(userID, gameID);
	}
	
	public void addGame() {
		
	}
	
	public GamesEntity findGame(long idGame) {
		
		return gamesDAO.findGameByID(idGame);
		
	}
}


