package com.capgemini.UserProfileAndRanking.Statistics;

public class StatisticsDTO {

	private int gamesPlayed;
	private int gamesWon;
	
	public StatisticsDTO(int gamesPlayed, int gamesWon) {
		super();
		this.gamesPlayed = gamesPlayed;
		this.gamesWon = gamesWon;
	}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	
	public int getGamesWon() {
		return gamesWon;
	}
	
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}
	
	
	
	
}
