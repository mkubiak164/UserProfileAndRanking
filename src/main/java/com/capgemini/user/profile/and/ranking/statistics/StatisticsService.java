package com.capgemini.user.profile.and.ranking.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.user.profile.and.ranking.enums.Level;
import com.capgemini.user.profile.and.ranking.games.GamesService;
import com.capgemini.user.profile.and.ranking.ranking.RankingDTO;
import com.capgemini.user.profile.and.ranking.ranking.RankingService;

public class StatisticsService {

	private GamesService gameService;
	private RankingService rankingService;
	
	@Autowired
	public StatisticsService(GamesService gameService, RankingService rankingService) {
		this.gameService = gameService;
		this.rankingService = rankingService;
	}
	
	public StatisticsDTO userStatistics(long gameID, long userID) {
		
		List<RankingDTO> gameRanking = rankingService.findGameRanking(gameID); 
			// pobieramy ranking dla gry o wskazanym id
		int gamesWon = (int) gameRanking.stream()
				.filter(ranking -> ranking.getWinnerID() == userID).count();
			// w rankingu gry filtrujemy czy id wygranego to id usera i zliczamy ile razy user wygrał
		int gamesPlayed = (int) gameRanking.stream()
				.filter(ranking -> ranking.getIdPlayers().contains(Long.valueOf(userID))).count();
			// to samo w id grających - czy wśród grających jest user i ile razy występuje
		return new StatisticsDTO(gamesPlayed, gamesWon);
			// na tej podstawie zwracana nowa statystyka
	}
	
	public Level userLevel(long userID){
		// poziom zaawansowania w zależności od ilości rozegranych gier (bez względu na wynik)

		List<RankingDTO> userGames = rankingService.findAllUserGames(userID);
		int gamesPlayed = userGames.size();
		Level userLevel;
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
	
	 public List<RankingDTO> showHistory(long userID) {
		 List<RankingDTO> userRanking = rankingService.findAllUserGames(userID);
		 return userRanking;

	 }

	
}
