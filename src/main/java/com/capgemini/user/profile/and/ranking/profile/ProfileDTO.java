package com.capgemini.user.profile.and.ranking.profile;

import java.util.List;

import com.capgemini.user.profile.and.ranking.games.GamesEntity;

public class ProfileDTO {
	
	private long id;
	private String name;
	private String lastName;
	private String email;
	private String password;
	private String motto;
	private List<GamesEntity> gameList;
	
	
	public ProfileDTO(long id, String name, String lastName, String email, String password, String motto) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.motto = motto;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public List<GamesEntity> getGameList() {
		return gameList;
	}

	public void setGameList(List<GamesEntity> gameList) {
		this.gameList = gameList;
	}

	
	
	
	
	
	
}
