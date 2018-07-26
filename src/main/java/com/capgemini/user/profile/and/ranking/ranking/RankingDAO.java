package com.capgemini.user.profile.and.ranking.ranking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class RankingDAO {

	private List<RankingEntity> rankingList = new ArrayList<>();
	
	
	public RankingDAO(List<RankingEntity> rankingList) {
		this.rankingList = rankingList;
	}
	
	public List<RankingEntity> findUserGamesHistory(long userID) {
		return rankingList.stream()
				.filter( currentUserHistory -> currentUserHistory.getUserID() == userID)
				.collect(Collectors.toList());
	}
	
	public List<RankingEntity> findGameRanking(long gameID) {
		return rankingList.stream()
			.filter( currentGameRanking -> currentGameRanking.getGameID() == gameID)
			.collect(Collectors.toList());
	}

}
