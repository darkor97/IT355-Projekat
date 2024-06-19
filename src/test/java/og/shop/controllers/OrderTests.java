package og.shop.controllers;

import og.shop.models.Order;
import og.shop.services.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderTests {

    private OrderService orderService;
    private OrderController orderController;

    @Before
    public void init() {
        orderService = Mockito.mock(OrderService.class);
        orderController = new OrderController(orderService);
    }

    @Test
    public void testsAll() {
        Mockito.when(orderService.GetAll()).thenReturn(Arrays.asList(new Order(), new Order(), new Order()));

        var res = orderController.All();

        assertNotNull(res);
        assertEquals(3, res.getBody().size());
    }

    @Test
    public void testById() {
        var order = new Order();
        order.setId(0L);
        Mockito.when(orderService.GetById(0L)).thenReturn(order);

        var res = orderController.GetById(0L);

        assertNotNull(res);
        assertEquals(0L, res.getBody().getId());
    }

    @Test
    public void testCreate() {
        var order = new Order();
        order.setTotal(5.0);
        var orderToReturn = new Order();
        orderToReturn.setTotal(order.getTotal());
        orderToReturn.setId(1L);
        Mockito.when(orderService.Add(order)).thenReturn(orderToReturn);

        var res = orderController.Create(order);

        assertNotNull(res);
        assertEquals(1, res.getBody().getId());
        assertEquals(5.0, res.getBody().getTotal());
    }

    @Test
    public void testUpdate() {
        var order = new Order();
        order.setTotal(5.0);
        var orderToReturn = new Order();
        orderToReturn.setTotal(5.0);
        orderToReturn.setId(1L);
        Mockito.when(orderService.Update(order)).thenReturn(orderToReturn);

        var res = orderController.Update(order);

        assertNotNull(res);
        assertEquals(1, res.getBody().getId());
        assertEquals(5.0, res.getBody().getTotal());
    }

    @Test
    public void testDelete() {
        Mockito.doNothing().when(orderService).Delete(0L);

        var res = orderController.Delete(0L);

        assertNotNull(res);
        assertEquals(200, res.getStatusCode().value());
    }
}
