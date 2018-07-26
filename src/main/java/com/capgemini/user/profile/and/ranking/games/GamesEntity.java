package com.capgemini.user.profile.and.ranking.games;

public class GamesEntity {
	
	private String title;
	private int minPlayers;
	private int maxPlayers;
	private int id;
	
	 public GamesEntity(String title, int minPlayers, int maxPlayers, int id) {
		 this.title = title;
		 this.maxPlayers = maxPlayers;
		 this.minPlayers = minPlayers;
		 this.id = id;
	 }
	 
	 public GamesEntity(GamesDTO gamesDTO) {
		 this.title = gamesDTO.getTitle();
		 this.minPlayers = gamesDTO.getMinPlayers();
		 this.maxPlayers = gamesDTO.getMaxPlayers();
		 this.id = gamesDTO.getID();
	 }

	 public String getTitle() {
		 return title;
	 }
	 
	 public int getMinPlayers() {
		 return minPlayers;
	 }
	 
	 public int getMaxPlayers() {
		 return maxPlayers;
	 }
	 
	 public int getID() {
		 return id;
	 }
	 
	 
}
