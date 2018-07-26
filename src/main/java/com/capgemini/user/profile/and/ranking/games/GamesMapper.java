package com.capgemini.user.profile.and.ranking.games;

import org.springframework.stereotype.Component;

@Component
public class GamesMapper {

	public GamesEntity addGameToService(GamesDTO gamesDTO) {
		return new GamesEntity(gamesDTO.getTitle(), gamesDTO.getMinPlayers(), 
				gamesDTO.getMaxPlayers(), gamesDTO.getID());
	}
	
	
}
