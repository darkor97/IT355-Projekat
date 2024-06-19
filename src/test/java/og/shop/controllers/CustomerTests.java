package og.shop.controllers;

import og.shop.models.Customer;
import og.shop.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerTests {

    private CustomerService customerService;
    private CustomerController customerController;

    @Before
    public void init() {
        customerService = Mockito.mock(CustomerService.class);
        customerController = new CustomerController(customerService);
    }

    @Test
    public void testsAll() {
        Mockito.when(customerService.GetAll()).thenReturn(Arrays.asList(new Customer(), new Customer(), new Customer()));

        var res = customerController.All();

        assertNotNull(res);
        assertEquals(3, res.getBody().size());
    }

    @Test
    public void testById() {
        var customer = new Customer();
        customer.setId(0L);
        Mockito.when(customerService.GetById(0L)).thenReturn(customer);

        var res = customerController.GetById(0L);

        assertNotNull(res);
        assertEquals(0L, res.getBody().getId());
    }

    @Test
    public void testCreate() {
        var customer = new Customer();
        customer.setName("Test");
        var customerToReturn = new Customer();
        customerToReturn.setName(customer.getName());
        customerToReturn.setId(1L);
        Mockito.when(customerService.Add(customer)).thenReturn(customerToReturn);

        var res = customerController.Create(customer);

        assertNotNull(res);
        assertEquals(1, res.getBody().getId());
        assertEquals("Test", res.getBody().getName());
    }

    @Test
    public void testUpdate() {
        var customer = new Customer();
        customer.setName("Test");
        var customerToReturn = new Customer();
        customerToReturn.setName("Updated Test");
        customerToReturn.setId(1L);
        Mockito.when(customerService.Update(customer)).thenReturn(customerToReturn);

        var res = customerController.Update(customer);

        assertNotNull(res);
        assertEquals(1, res.getBody().getId());
        assertEquals("Updated Test", res.getBody().getName());
    }

    @Test
    public void testDelete() {
        Mockito.doNothing().when(customerService).Delete(0L);

        var res = customerController.Delete(0L);

        assertNotNull(res);
        assertEquals(200, res.getStatusCode().value());
    }
}
