package com.capgemini.UserProfileAndRanking.UserBoardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserBoardGameDAO {

	private List<UserBoardGameEntity> userBoardGamesList = new ArrayList<>();
	
	public List<UserBoardGameEntity> findUserBoardGames(long idUser) {
		
		return userBoardGamesList.stream()
		.filter(userGame -> userGame.getUserID() == idUser)
		.collect(Collectors.toList());
		
		
	}
	
	
	
}
