//package or.shop.services.services;
//
//import og.shop.ShopApplication;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(classes = {ShopApplication.class})
//@Transactional
//public class GamesTests {
//    @Autowired
//    private GamesService gamesService;
//
//    private Long id = 1000L;
//
//    @BeforeEach
//    public void init() {
//        var games = new Games();
//        games.name = "Test games";
//        games.season = "Summer";
//        games.year = 2024;
//        games.Id = id;
//        gamesService.Add(games);
//    }
//
//    @Test
//    public void testGetById() {
//        var games = gamesService.GetById(id);
//        assertNotNull(games);
//        assertEquals(id, games.Id);
//        assertEquals("Test games", games.name);
//        assertEquals("Summer", games.season);
//    }
//
//    @Test
//    public void testGetAll() {
//        var games = gamesService.GetById(id);
//        var allGames = gamesService.GetAll();
//        assertNotNull(allGames);
//        assertTrue(allGames.size() > 1);
//        assertTrue(allGames.contains(games));
//    }
//
//    @Test
//    public void testUpdate() {
//        var games = gamesService.GetById(id);
//        games.name = "Test games updated";
//        gamesService.Update(games);
//
//        var updatedGames = gamesService.GetById(id);
//
//        assertNotNull(games);
//        assertEquals(id, games.Id);
//        assertEquals("Test games updated", updatedGames.name);
//        assertEquals("Summer", updatedGames.season);
//    }
//
//    @Test
//    public void testDelete() {
//        var games = gamesService.GetById(1000L);
//        gamesService.Delete(games.Id);
//
//        var deletedGames = gamesService.GetById(games.Id);
//
//        assertNull(deletedGames);
//    }
//}
