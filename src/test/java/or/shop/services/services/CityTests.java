//package or.shop.services.services;
//
//import og.shop.ShopApplication;
//import og.shop.services.InventoryService;
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
//public class CityTests {
//    @Autowired
//    private InventoryService cityService;
//
//    @BeforeEach
//    public void init() {
//        var city = new City();
//        city.Id = 1000L;
//        city.Name = "Test city";
//        cityService.Add(city);
//    }
//
//    @Test
//    public void testGetById() {
//        var city = cityService.GetById(1000L);
//        assertNotNull(city);
//        assertEquals(1000L, city.Id);
//        assertEquals("Test city", city.Name);
//    }
//
//    @Test
//    public void testGetAll() {
//        var city = cityService.GetById(1000L);
//        var cities = cityService.GetAll();
//        assertNotNull(cities);
//        assertTrue(cities.size() > 1);
//        assertTrue(cities.contains(city));
//    }
//
//    @Test
//    public void testUpdate() {
//        var city = cityService.GetById(1000L);
//        city.Name = "Test city updated";
//        cityService.Update(city);
//
//        var updatedCity = cityService.GetById(1000L);
//
//        assertNotNull(city);
//        assertEquals(1000L, updatedCity.Id);
//        assertEquals("Test city updated", updatedCity.Name);
//    }
//
//    @Test
//    public void testDelete() {
//        var city = cityService.GetById(1000L);
//        cityService.Delete(city.Id);
//
//        var deletedCity = cityService.GetById(city.Id);
//
//        assertNull(deletedCity);
//    }
//}
