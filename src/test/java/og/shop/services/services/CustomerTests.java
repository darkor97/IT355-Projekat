package og.shop.services.services;

import og.shop.ShopApplication;
import og.shop.models.Customer;
import og.shop.services.CustomerService;
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
public class CustomerTests {
    @Autowired
    private CustomerService customerService;

    @BeforeEach
    public void init() {
        var customer = new Customer();
        customer.setName("Test");
        customerService.Add(customer);
    }

    @Test
    public void testGetById() {
        var customer = customerService.GetById(1L);
        assertNotNull(customer);
        assertEquals(1L, customer.getId());
        assertEquals("Test", customer.getName());
    }

    @Test
    public void testGetAll() {
        var customer = customerService.GetById(1L);
        var customers = customerService.GetAll();
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
        assertTrue(customers.contains(customer));
    }

    @Test
    public void testUpdate() {
        var customer = customerService.GetById(1L);
        customer.setName("Test updated");
        customerService.Update(customer);

        var updatedCustomer = customerService.GetById(1L);

        assertNotNull(customer);
        assertEquals(1L, updatedCustomer.getId());
        assertEquals("Test updated", updatedCustomer.getName());
    }

    @Test
    public void testDelete() {
        var customer = customerService.GetById(1L);
        customerService.Delete(customer.getId());

        var deletedCustomer = customerService.GetById(customer.getId());

        assertNull(deletedCustomer);
    }
}
