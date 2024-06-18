//package or.shop.services.services;
//
//import jakarta.transaction.Transactional;
//import og.shop.ShopApplication;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(classes = {ShopApplication.class})
//@Transactional
//public class EventTests {
//    private Long id = 0L;
//    @Autowired
//    private EventService eventService;
//
//    @BeforeEach
//    public void init() {
//        var event = new Event();
//        event.Name = "Test event";
//        var createdEvent = eventService.Add(event);
//        id = createdEvent.Id;
//    }
//
//    @Test
//    public void testGetById() {
//        var games = eventService.GetById(id);
//        assertNotNull(games);
//        assertEquals(id, games.Id);
//        assertEquals("Test event", games.Name);
//    }
//
//    @Test
//    public void testGetAll() {
//        var event = eventService.GetById(id);
//        var allEvents = eventService.GetAll();
//        assertNotNull(allEvents);
//        assertTrue(allEvents.size() > 1);
//        assertTrue(allEvents.contains(event));
//    }
//
//    @Test
//    public void testUpdate() {
//        var event = eventService.GetById(id);
//        event.Name = "Test event updated";
//        eventService.Update(event);
//
//        var updatedEvent = eventService.GetById(id);
//
//        assertNotNull(event);
//        assertEquals(id, event.Id);
//        assertEquals("Test event updated", updatedEvent.Name);
//    }
//
//    @Test
//    public void testDelete() {
//        var event = eventService.GetById(id);
//        eventService.Delete(event.Id);
//
//        var deleteEvent = eventService.GetById(event.Id);
//
//        assertNull(deleteEvent);
//    }
//}
