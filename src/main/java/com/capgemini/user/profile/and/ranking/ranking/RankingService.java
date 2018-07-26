package com.capgemini.user.profile.and.ranking.ranking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.user.profile.and.ranking.profile.ProfileService;

public class RankingService {

	private ProfileService profileService;
	
	
	@Autowired
	public RankingService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public List<RankingDTO> findGameRanking(long gameID) {
		
		return null;
	}

	public List<RankingDTO> findAllUserGames(long userID) {
		
		return null;
	}
	
	public int userRankingPosition(long userID, long gameID) {
		
		List<RankingDTO> gameRanking = findGameRanking(gameID);
		HashMap<Long, Integer> userPoints = new HashMap<>();
			
		profileService.findAllUsers().forEach(user -> {
			int currentPoints = 0;
			for(RankingDTO ranking : gameRanking) {
				if(ranking.getWinnerID() == userID){
					currentPoints++;			
				}
			}
			userPoints.put(userID, currentPoints);
		});
		
		int userGamePoints = userPoints.get(Long.valueOf(userID));
		int rankingPosition = 1;
			// przypisujemy na starcie 1 pozycje w rankingu
		for(Map.Entry<Long, Integer> entry : userPoints.entrySet()) {
			if(entry.getValue() > userGamePoints) {
				rankingPosition++;
			}
		}
			// porównujemy po kolei ilośc punktów innych userów,
			// jeżeli ktoś ma więcej wygranych, to pozycja usera w rankingu się zwiększa o 1 
		return rankingPosition;
	}
		
}

