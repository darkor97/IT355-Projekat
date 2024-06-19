package og.shop.controllers;

import og.shop.models.Item;
import og.shop.services.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemTests {

    private ItemService itemService;
    private ItemController itemController;

    @Before
    public void init() {
        itemService = Mockito.mock(ItemService.class);
        itemController = new ItemController(itemService);
    }

    @Test
    public void testsAll() {
        Mockito.when(itemService.GetAll()).thenReturn(Arrays.asList(new Item(), new Item(), new Item()));

        var res = itemController.All();

        assertNotNull(res);
        assertEquals(3, res.getBody().size());
    }

    @Test
    public void testById() {
        var item = new Item();
        item.setId(0L);
        Mockito.when(itemService.GetById(0L)).thenReturn(item);

        var res = itemController.GetById(0L);

        assertNotNull(res);
        assertEquals(0L, res.getBody().getId());
    }

    @Test
    public void testCreate() {
        var item = new Item();
        item.setName("Test");
        var itemToReturn = new Item();
        itemToReturn.setName(item.getName());
        itemToReturn.setId(1L);
        Mockito.when(itemService.Add(item)).thenReturn(itemToReturn);

        var res = itemController.Create(item);

        assertNotNull(res);
        assertEquals(1, res.getBody().getId());
        assertEquals("Test", res.getBody().getName());
    }

    @Test
    public void testUpdate() {
        var item = new Item();
        item.setName("Test");
        var itemToReturn = new Item();
        itemToReturn.setName("Updated Test");
        itemToReturn.setId(1L);
        Mockito.when(itemService.Update(item)).thenReturn(itemToReturn);

        var res = itemController.Update(item);

        assertNotNull(res);
        assertEquals(1, res.getBody().getId());
        assertEquals("Updated Test", res.getBody().getName());
    }

    @Test
    public void testDelete() {
        Mockito.doNothing().when(itemService).Delete(0L);

        var res = itemController.Delete(0L);

        assertNotNull(res);
        assertEquals(200, res.getStatusCode().value());
    }
}
