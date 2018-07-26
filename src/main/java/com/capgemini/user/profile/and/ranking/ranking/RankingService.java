package com.capgemini.user.profile.and.ranking.ranking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.user.profile.and.ranking.profile.ProfileService;

@Service
public class RankingService {

	private ProfileService profileService;
	private RankingDAO rankingDAO;
	private RankingMapper rankingMapper;
	
	@Autowired
	public RankingService(ProfileService profileService, RankingDAO rankingDAO, RankingMapper rankingMapper) {
		this.profileService = profileService;
		this.rankingDAO = rankingDAO;
		this.rankingMapper = rankingMapper;
	}

	public List<RankingDTO> findGameRanking(long gameID) {
		
		List<RankingEntity> rankingEntities = rankingDAO.findGameRanking(gameID);
		List<RankingDTO> rankingDTOs = new ArrayList<>();
		rankingEntities.stream().forEach(r -> {
			rankingDTOs.add(rankingMapper.from(r));
		});
		return rankingDTOs;
	}

	public List<RankingDTO> findAllUserGames(long userID) {
		
		List<RankingEntity> rankingEntities = rankingDAO.findUserGamesHistory(userID);
		List<RankingDTO> rankingDTOs = new ArrayList<>();
		rankingEntities.stream().forEach(r -> {
			rankingDTOs.add(rankingMapper.from(r));
		});
		return rankingDTOs;
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

