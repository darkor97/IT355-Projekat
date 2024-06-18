//package or.shop.controllers;
//
//import og.shop.controllers.GamesController;
//import og.shop.services.GamesService;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class GamesTests {
//
//    private GamesService gamesService;
//    private GamesController gamesController;
//
//    @Before
//    public void init() {
//        gamesService = Mockito.mock(GamesService.class);
//        gamesController = new GamesController(gamesService);
//    }
//
//    @Test
//    public void testsAll() {
//        Mockito.when(gamesService.GetAll()).thenReturn(Arrays.asList(new Games(), new Games(), new Games()));
//
//        var res = gamesController.All();
//
//        assertNotNull(res);
//        assertEquals(3, res.getBody().size());
//    }
//
//    @Test
//    public void testById() {
//        var games = new Games();
//        games.name = "Test games";
//        Mockito.when(gamesService.GetById(0L)).thenReturn(games);
//
//        var res = gamesController.GetById(0L);
//
//        assertNotNull(res);
//        assertEquals("Test games", res.getBody().name);
//    }
//
//    @Test
//    public void testCreate() {
//        var games = new Games();
//        games.name = "Test games";
//        var gamesToReturn = new Games();
//        gamesToReturn.name = games.name;
//        gamesToReturn.year = 2024;
//        Mockito.when(gamesService.Add(games)).thenReturn(gamesToReturn);
//
//        var res = gamesController.CreateGames(games);
//
//        assertNotNull(res);
//        assertEquals("Test games", res.getBody().name);
//        assertEquals(2024, res.getBody().year);
//    }
//
//    @Test
//    public void testUpdate() {
//        var games = new Games();
//        games.name = "Test";
//        var gamesToReturn = new Games();
//        gamesToReturn.name = "Updated Test";
//        gamesToReturn.year = 2024;
//        Mockito.when(gamesService.Update(games)).thenReturn(gamesToReturn);
//
//        var res = gamesController.UpdateGames(games);
//
//        assertNotNull(res);
//        assertEquals("Updated Test", res.getBody().name);
//        assertEquals(2024, res.getBody().year);
//    }
//
//    @Test
//    public void testDelete() {
//        Mockito.doNothing().when(gamesService).Delete(0L);
//
//        var res = gamesController.DeletGames(0L);
//
//        assertNotNull(res);
//        assertEquals(200, res.getStatusCode().value());
//    }
//}
