package com.capgemini.user.profile.and.ranking.userBoardGame;


public class UserBoardGameEntity {
	
	private long gameID;
	private long userID;
	
	public UserBoardGameEntity(long gameID, long userID) {
		this.gameID = gameID;
		this.userID = userID;
	}
	
	public long getGameID() {
		return gameID;
	}

	public void setGameID(long gameID) {
		this.gameID = gameID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

}
