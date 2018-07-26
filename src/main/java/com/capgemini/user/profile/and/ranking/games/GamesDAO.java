package com.capgemini.user.profile.and.ranking.games;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.user.profile.and.ranking.userBoardGame.UserBoardGameDAO;

@Repository
public class GamesDAO {
	
	private List<GamesEntity> gamesList = new ArrayList<>();
	private UserBoardGameDAO userBoardGameDAO;
	
	@Autowired
	public GamesDAO(UserBoardGameDAO userBoardGameDAO) {
		this.userBoardGameDAO = userBoardGameDAO;
	}
	
	//potrzebny w testach
	public GamesDAO(List<GamesEntity> games) {
		this.gamesList = games;
	}
	
	public List<GamesEntity> showAllGames() {
		return gamesList;
	}
	
	public void addGameToUser(long userID, long gameID) {
		userBoardGameDAO.add(userID, gameID);
	}
	
	public void removeGame(long userID, long gameID) {
		userBoardGameDAO.removeUserGame(userID, gameID);
	}
	
	public GamesEntity findGameByID(long id) {
		return gamesList.stream().filter(gameByID -> gameByID.getID() == id)
				.findFirst().orElseGet(null);
	}
	
	public void addGameToService(GamesEntity gamesEntity) {
		gamesList.add(gamesEntity);
	}

}
