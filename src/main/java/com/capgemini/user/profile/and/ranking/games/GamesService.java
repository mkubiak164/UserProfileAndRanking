package com.capgemini.user.profile.and.ranking.games;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamesService {

	private GamesDAO gamesDAO;
	private GamesMapper gamesMapper;

	@Autowired
	public GamesService(GamesDAO gamesDAO, GamesMapper gamesMapper) {
		this.gamesDAO = gamesDAO;
		this.gamesMapper = gamesMapper;
	}

	public List<GamesEntity> findAllGames() {
		List<GamesEntity> allGames = gamesDAO.showAllGames();
		return allGames;
	}

	public void removeGame(long userID, long gameID) {
		gamesDAO.removeGame(userID, gameID);
	}

	public void addGameToUser(long userID, long gameID) {
		gamesDAO.addGameToUser(userID, gameID);
	}

	public GamesEntity findGame(long idGame) {

		return gamesDAO.findGameByID(idGame);

	}

	public void addGameToService(GamesDTO gamesDTO) {
		GamesEntity gamesEntity = gamesMapper.addGameToService(gamesDTO);
		gamesDAO.addGameToService(gamesEntity);
	}
}
