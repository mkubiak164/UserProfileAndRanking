package com.capgemini.UserProfileAndRanking.Statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.UserProfileAndRanking.Enums.Level;
import com.capgemini.UserProfileAndRanking.Games.GamesService;
import com.capgemini.UserProfileAndRanking.Ranking.RankingDTO;
import com.capgemini.UserProfileAndRanking.Ranking.RankingService;

public class StatisticsService {

	private GamesService gameService;
	private RankingService rankingService;
	private Level level;
	private Level userLevel;
	
	@Autowired
	public StatisticsService(GamesService gameService, RankingService rankingService) {
		this.gameService = gameService;
		this.rankingService = rankingService;
	}
	
	public StatisticsDTO userStatistics(long gameID, long userID) {
		
		List<RankingDTO> gameRanking = rankingService.findGameRanking(gameID);
		int gamesWon = (int) gameRanking.stream()
				.filter(ranking -> ranking.getWinnerID() == userID).count();
		int gamesPlayed = (int) gameRanking.stream()
				.filter(ranking -> ranking.getIdPlayers().contains(Long.valueOf(userID))).count();
		
		return new StatisticsDTO(gamesPlayed, gamesWon);
	}
	
	
	public Level userLevel(long userID){
	
		List<RankingDTO> userGames = rankingService.findAllUserGames(userID);
		int gamesPlayed = userGames.size();
		
		if(gamesPlayed<10) {
			userLevel = Level.BEGGINER;
		} else if(gamesPlayed<30) {
			userLevel = Level.INTERMEDIATE;
		} else if(gamesPlayed<70) {
			userLevel = Level.ADVANCED;
		} else {
			userLevel = Level.EXPERT;
		}
		
		return userLevel;
	}
	
	public 

	
}
