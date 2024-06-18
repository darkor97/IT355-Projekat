//package or.shop.controllers;
//
//import og.shop.controllers.EventController;
//import og.shop.services.EventService;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class EventTests {
//
//    private EventService eventService;
//    private EventController eventController;
//
//    @Before
//    public void init() {
//        eventService = Mockito.mock(EventService.class);
//        eventController = new EventController(eventService);
//    }
//
//    @Test
//    public void testsAll() {
//        Mockito.when(eventService.GetAll()).thenReturn(Arrays.asList(new Event(), new Event(), new Event()));
//
//        var res = eventController.All();
//
//        assertNotNull(res);
//        assertEquals(3, res.getBody().size());
//    }
//
//    @Test
//    public void testById() {
//        var event = new Event();
//        event.Id = 0L;
//        Mockito.when(eventService.GetById(0L)).thenReturn(event);
//
//        var res = eventController.GetById(0L);
//
//        assertNotNull(res);
//        assertEquals(0L, res.getBody().Id);
//    }
//
//    @Test
//    public void testCreate() {
//        var event = new Event();
//        event.Name = "Test";
//        var eventToReturn = new Event();
//        eventToReturn.Name = event.Name;
//        eventToReturn.Id = 1L;
//        Mockito.when(eventService.Add(event)).thenReturn(eventToReturn);
//
//        var res = eventController.CreateEvent(event);
//
//        assertNotNull(res);
//        assertEquals(1, res.getBody().Id);
//        assertEquals("Test", res.getBody().Name);
//    }
//
//    @Test
//    public void testUpdate() {
//        var event = new Event();
//        event.Name = "Test";
//        var eventToReturn = new Event();
//        eventToReturn.Name = "Updated Test";
//        eventToReturn.Id = 1L;
//        Mockito.when(eventService.Update(event)).thenReturn(eventToReturn);
//
//        var res = eventController.UpdateEvent(event);
//
//        assertNotNull(res);
//        assertEquals(1, res.getBody().Id);
//        assertEquals("Updated Test", res.getBody().Name);
//    }
//
//    @Test
//    public void testDelete() {
//        Mockito.doNothing().when(eventService).Delete(0L);
//
//        var res = eventController.DeleteEvent(0L);
//
//        assertNotNull(res);
//        assertEquals(200, res.getStatusCode().value());
//    }
//}
