//package or.shop.controllers;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import og.shop.controllers.JmsController;
//import og.shop.services.EventService;
//import og.shop.services.ProducerService;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class JmsTests {
//
//    private ProducerService producerService;
//    private EventService eventService;
//
//    private JmsController jmsController;
//
//    @Before
//    public void init() {
//        producerService = Mockito.mock(ProducerService.class);
//        eventService = Mockito.mock(EventService.class);
//        jmsController = new JmsController(producerService, eventService);
//    }
//
//    @Test
//    public void testProducer() throws JsonProcessingException {
//        Mockito.doNothing().when(producerService).SendMessage("{\"Id\": \"1\", \"Name\":\"Test\"}}");
//
//        var res = jmsController.PublishMessage("Test");
//
//        assertNotNull(res);
//        assertEquals(200, res.getStatusCode().value());
//    }
//
//    @Test
//    public void testConsumer() {
//        var event = new Event();
//        event.Id = 1L;
//        event.Name = "Test";
//        Mockito.when(eventService.GetById(1L)).thenReturn(event);
//
//        var res = jmsController.GetStatus(1L);
//
//        assertNotNull(res);
//        assertEquals(1L, res.getBody().Id);
//        assertEquals("Test", res.getBody().Name);
//    }
//}
