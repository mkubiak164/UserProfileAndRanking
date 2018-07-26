package com.capgemini.UserProfileAndRanking.games;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.user.profile.and.ranking.ranking.RankingDAO;
import com.capgemini.user.profile.and.ranking.ranking.RankingEntity;

public class RankingDAOTest {

	private RankingDAO rankingDAO;
	
	@Before
	public void initializeTest() {
		List<RankingEntity> rankingList = new ArrayList<>();
		
		RankingEntity r1 = new RankingEntity(1, 1, new ArrayList<>(), LocalDateTime.now());
		RankingEntity r2 = new RankingEntity(2, 2, new ArrayList<>(), LocalDateTime.now());
		
		rankingList.add(r1);
		rankingList.add(r2);
		
		this.rankingDAO = new RankingDAO(rankingList);
	}
	
	@Test
	public void shouldFindGame() {
		
		//when
		List<RankingEntity> foundGame = rankingDAO.findGameRanking(1);
		
		//then
		Assertions.assertThat(foundGame).hasSize(1);
		Assertions.assertThat(foundGame.get(0).getUserID()).isEqualTo(1);
	}
	
	@Test
	public void shouldFindUser() {
		
		//when
		List<RankingEntity> foundUser = rankingDAO.findUserGamesHistory(2);
		
		//then
		Assertions.assertThat(foundUser).hasSize(1);
		Assertions.assertThat(foundUser.get(0).getUserID()).isEqualTo(2);
	}
	
}
