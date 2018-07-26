package com.capgemini.UserProfileAndRanking.Ranking;

import java.time.LocalDateTime;
import java.util.List;

public class RankingEntity {

	private long winnerID;
	private long gameID;
	private List<Long> idPlayers;
	private LocalDateTime dateTime;
	
	public RankingEntity(long userID, long gameID, List<Long> idPlayers, LocalDateTime dateTime) {
		this.winnerID = userID;
		this.gameID = gameID;
		this.idPlayers = idPlayers;
		this.dateTime = dateTime;
	}
	

	public long getUserID() {
		return winnerID;
	}

	public void setUserID(long userID) {
		this.winnerID = userID;
	}

	public long getGameID() {
		return gameID;
	}

	public void setGameID(long gameID) {
		this.gameID = gameID;
	}

	public List<Long> getIdPlayers() {
		return idPlayers;
	}

	public void setIdPlayers(List<Long> idPlayers) {
		this.idPlayers = idPlayers;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
