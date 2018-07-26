package com.capgemini.user.profile.and.ranking.ranking;

import java.time.LocalDateTime;
import java.util.List;

public class RankingMapper {

	public RankingDTO from(RankingEntity rankingEntity) {
		
		return new RankingDTO(rankingEntity.getUserID(), rankingEntity.getGameID(), 
				rankingEntity.getIdPlayers(), rankingEntity.getDateTime());
		
	}
	
}