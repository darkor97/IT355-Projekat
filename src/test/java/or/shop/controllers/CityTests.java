//package or.shop.controllers;
//
//import og.shop.controllers.CityController;
//import og.shop.services.CityService;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class CityTests {
//
//    private CityService cityService;
//    private CityController cityController;
//
//    @Before
//    public void init() {
//        cityService = Mockito.mock(CityService.class);
//        cityController = new CityController(cityService);
//    }
//
//    @Test
//    public void testsAll() {
//        Mockito.when(cityService.GetAll()).thenReturn(Arrays.asList(new City(), new City(), new City()));
//
//        var res = cityController.All();
//
//        assertNotNull(res);
//        assertEquals(3, res.getBody().size());
//    }
//
//    @Test
//    public void testById() {
//        var city = new City();
//        city.Id = 0L;
//        Mockito.when(cityService.GetById(0L)).thenReturn(city);
//
//        var res = cityController.GetById(0L);
//
//        assertNotNull(res);
//        assertEquals(0L, res.getBody().Id);
//    }
//
//    @Test
//    public void testCreate() {
//        var city = new City();
//        city.Name = "Test";
//        var cityToReturn = new City();
//        cityToReturn.Name = city.Name;
//        cityToReturn.Id = 1L;
//        Mockito.when(cityService.Add(city)).thenReturn(cityToReturn);
//
//        var res = cityController.CreateCity(city);
//
//        assertNotNull(res);
//        assertEquals(1, res.getBody().Id);
//        assertEquals("Test", res.getBody().Name);
//    }
//
//    @Test
//    public void testUpdate() {
//        var city = new City();
//        city.Name = "Test";
//        var cityToReturn = new City();
//        cityToReturn.Name = "Updated Test";
//        cityToReturn.Id = 1L;
//        Mockito.when(cityService.Update(city)).thenReturn(cityToReturn);
//
//        var res = cityController.UpdateCity(city);
//
//        assertNotNull(res);
//        assertEquals(1, res.getBody().Id);
//        assertEquals("Updated Test", res.getBody().Name);
//    }
//
//    @Test
//    public void testDelete() {
//        Mockito.doNothing().when(cityService).Delete(0L);
//
//        var res = cityController.DeleteCity(0L);
//
//        assertNotNull(res);
//        assertEquals(200, res.getStatusCode().value());
//    }
//}
