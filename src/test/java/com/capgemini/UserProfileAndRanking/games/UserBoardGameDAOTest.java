package com.capgemini.UserProfileAndRanking.games;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.user.profile.and.ranking.games.GamesDAO;
import com.capgemini.user.profile.and.ranking.games.GamesEntity;
import com.capgemini.user.profile.and.ranking.userBoardGame.UserBoardGameDAO;
import com.capgemini.user.profile.and.ranking.userBoardGame.UserBoardGameEntity;

public class UserBoardGameDAOTest {

	private UserBoardGameDAO userBoarGameDAO;	
	
	@Before
	public void initTest() {
		List<UserBoardGameEntity> entities = new ArrayList<>();
		UserBoardGameEntity g1 = new UserBoardGameEntity(1, 1);
		UserBoardGameEntity g2 = new UserBoardGameEntity(2, 1);
		UserBoardGameEntity g3 = new UserBoardGameEntity(2, 2);
		
		entities.add(g1);
		entities.add(g2);
		entities.add(g3);
		
		userBoarGameDAO = new UserBoardGameDAO(entities);
	}
	
	@Test
	public void shouldFindAllUserGames() {
		//when
		List<UserBoardGameEntity> foundGames = userBoarGameDAO.findUserBoardGames(1);
		
		//then
		Assertions.assertThat(foundGames).hasSize(2);
	}
	
	
}
