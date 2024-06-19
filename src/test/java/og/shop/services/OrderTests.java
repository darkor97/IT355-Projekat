package og.shop.services;

import og.shop.ShopApplication;
import og.shop.models.Order;
import og.shop.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {ShopApplication.class})
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderTests {
    @Autowired
    private OrderService inventoryService;

    @BeforeEach
    public void init() {
        var order = new Order();
        order.setTotal(5.0);
        inventoryService.Add(order);
    }

    @Test
    public void testGetById() {
        var order = inventoryService.GetById(1L);
        assertNotNull(order);
        assertEquals(1L, order.getId());
        assertEquals(5.0, order.getTotal());
    }

    @Test
    public void testGetAll() {
        var order = inventoryService.GetById(1L);
        var orders = inventoryService.GetAll();
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
        assertTrue(orders.contains(order));
    }

    @Test
    public void testUpdate() {
        var order = inventoryService.GetById(1L);
        inventoryService.Update(order);

        var updatedOrder = inventoryService.GetById(1L);

        assertNotNull(order);
        assertEquals(1L, updatedOrder.getId());
        assertEquals(5.0, updatedOrder.getTotal());
    }

    @Test
    public void testDelete() {
        var order = inventoryService.GetById(1L);
        inventoryService.Delete(order.getId());

        var deletedOrder = inventoryService.GetById(order.getId());

        assertNull(deletedOrder);
    }
}
