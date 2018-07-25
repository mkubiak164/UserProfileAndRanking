package com.capgemini.UserProfileAndRanking.Games;

public class GameTitleDTO {

	private String title;
	
	
	public GameTitleDTO(GamesEntity gamesEntity) {
		this.title = gamesEntity.getTitle();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
}
