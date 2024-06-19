package og.shop.services.services;

import og.shop.ShopApplication;
import og.shop.models.Inventory;
import og.shop.services.InventoryService;
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
public class InventoryTests {
    @Autowired
    private InventoryService inventoryService;

    @BeforeEach
    public void init() {
        var inventory = new Inventory();
        inventory.setNumberOfItems(5);
        inventoryService.Add(inventory);
    }

    @Test
    public void testGetById() {
        var inventory = inventoryService.GetById(1L);
        assertNotNull(inventory);
        assertEquals(1L, inventory.getId());
        assertEquals(5, inventory.getNumberOfItems());
    }

    @Test
    public void testGetAll() {
        var inventory = inventoryService.GetById(1L);
        var inventories = inventoryService.GetAll();
        assertNotNull(inventories);
        assertFalse(inventories.isEmpty());
        assertTrue(inventories.contains(inventory));
    }

    @Test
    public void testUpdate() {
        var inventory = inventoryService.GetById(1L);
        inventoryService.Update(inventory);

        var updatedInventory = inventoryService.GetById(1L);

        assertNotNull(inventory);
        assertEquals(1L, updatedInventory.getId());
        assertEquals(5, updatedInventory.getNumberOfItems());
    }

    @Test
    public void testDelete() {
        var inventory = inventoryService.GetById(1L);
        inventoryService.Delete(inventory.getId());

        var deletedInventory = inventoryService.GetById(inventory.getId());

        assertNull(deletedInventory);
    }
}
