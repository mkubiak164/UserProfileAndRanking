package com.capgemini.UserProfileAndRanking.games;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.user.profile.and.ranking.games.GamesDAO;
import com.capgemini.user.profile.and.ranking.games.GamesEntity;

public class GamesDAOTest {
	
	private GamesDAO gamesDAO;	
	
	@Before
	public void setGames() {
		List<GamesEntity> games = new ArrayList<>();
		GamesEntity g1 = new GamesEntity("bierki", 2, 10, 1);
		GamesEntity g2 = new GamesEntity("chinczyk", 2, 4, 2);
		
		games.add(g1);
		games.add(g2);
		
		gamesDAO = new GamesDAO(games);
	}
	
	@Test
	public void shouldFindAllGames() {
		//when
		List<GamesEntity> foundGames = gamesDAO.showAllGames();
		
		//then
		Assertions.assertThat(foundGames).hasSize(2);
	}
	
}
