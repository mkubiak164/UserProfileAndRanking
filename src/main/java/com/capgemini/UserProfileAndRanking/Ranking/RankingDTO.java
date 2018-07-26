package com.capgemini.UserProfileAndRanking.Ranking;

import java.time.LocalDateTime;
import java.util.List;

public class RankingDTO {

	private long winnerID;
	private long gameID;
	private List<Long> idPlayers;
	private LocalDateTime dateTime;
	
	
	
	
	public long getWinnerID() {
		return winnerID;
	}
	public void setWinnerID(long winnerID) {
		this.winnerID = winnerID;
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
