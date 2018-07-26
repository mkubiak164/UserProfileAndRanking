package com.capgemini.UserProfileAndRanking.games;

import com.capgemini.user.profile.and.ranking.games.GamesDAO;
import com.capgemini.user.profile.and.ranking.games.GamesEntity;
import com.capgemini.user.profile.and.ranking.games.GamesService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class GameServiceTest {

    @Mock
    private GamesDAO gamesDAO;

    @InjectMocks
    private GamesService gamesService;

    @Test
    public void shouldFindAllGames() {
    	
    	//given
    	GamesEntity gamesEntity = new GamesEntity("bierki podwodne", 2, 10, 1);
        ArrayList<GamesEntity> gamesList = new ArrayList<>();
        gamesList.add(gamesEntity);
        
        Mockito.when(gamesDAO.showAllGames()).thenReturn(gamesList);

        //when
        List<GamesEntity> allGames = gamesService.findAllGames();

        //then
        Assertions.assertThat(allGames).isEqualTo(gamesList);
        Assertions.assertThat(allGames).hasSize(1);

    }

    @Test
    public void shouldFindGameById() {
        
    	//given
    	GamesEntity gamesEntity = new GamesEntity("bierki podwodne", 2, 10, 1);

        Mockito.when(gamesDAO.findGameByID(1)).thenReturn(gamesEntity);

        //when
        GamesEntity game = gamesService.findGame(1);

        //then
        Assertions.assertThat(game.getTitle()).isEqualTo("bierki podwodne");
    }

    

}