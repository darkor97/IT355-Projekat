package og.shop.controllers;

import og.shop.models.Inventory;
import og.shop.services.InventoryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InventoryTests {

    private InventoryService inventoryService;
    private InventoryController inventoryController;

    @Before
    public void init() {
        inventoryService = Mockito.mock(InventoryService.class);
        inventoryController = new InventoryController(inventoryService);
    }

    @Test
    public void testsAll() {
        Mockito.when(inventoryService.GetAll()).thenReturn(Arrays.asList(new Inventory(), new Inventory(), new Inventory()));

        var res = inventoryController.All();

        assertNotNull(res);
        assertEquals(3, res.getBody().size());
    }

    @Test
    public void testById() {
        var inventory = new Inventory();
        inventory.setId(0L);
        Mockito.when(inventoryService.GetById(0L)).thenReturn(inventory);

        var res = inventoryController.GetById(0L);

        assertNotNull(res);
        assertEquals(0L, res.getBody().getId());
    }

    @Test
    public void testCreate() {
        var inventory = new Inventory();
        inventory.setNumberOfItems(5);
        var inventoryToReturn = new Inventory();
        inventoryToReturn.setNumberOfItems(inventory.getNumberOfItems());
        inventoryToReturn.setId(1L);
        Mockito.when(inventoryService.Add(inventory)).thenReturn(inventoryToReturn);

        var res = inventoryController.Create(inventory);

        assertNotNull(res);
        assertEquals(1, res.getBody().getId());
        assertEquals(5, res.getBody().getNumberOfItems());
    }

    @Test
    public void testUpdate() {
        var inventory = new Inventory();
        inventory.setNumberOfItems(5);
        var inventoryToReturn = new Inventory();
        inventoryToReturn.setNumberOfItems(5);
        inventoryToReturn.setId(1L);
        Mockito.when(inventoryService.Update(inventory)).thenReturn(inventoryToReturn);

        var res = inventoryController.Update(inventory);

        assertNotNull(res);
        assertEquals(1, res.getBody().getId());
        assertEquals(5, res.getBody().getNumberOfItems());
    }

    @Test
    public void testDelete() {
        Mockito.doNothing().when(inventoryService).Delete(0L);

        var res = inventoryController.Delete(0L);

        assertNotNull(res);
        assertEquals(200, res.getStatusCode().value());
    }
}
