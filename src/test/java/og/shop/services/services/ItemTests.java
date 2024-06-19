package og.shop.services.services;

import og.shop.ShopApplication;
import og.shop.models.Item;
import og.shop.services.ItemService;
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
public class ItemTests {
    @Autowired
    private ItemService itemService;

    @BeforeEach
    public void init() {
        var item = new Item();
        item.setName("Test");
        itemService.Add(item);
    }

    @Test
    public void testGetById() {
        var item = itemService.GetById(1L);
        assertNotNull(item);
        assertEquals(1L, item.getId());
        assertEquals("Test", item.getName());
    }

    @Test
    public void testGetAll() {
        var item = itemService.GetById(1L);
        var items = itemService.GetAll();
        assertNotNull(items);
        assertFalse(items.isEmpty());
        assertTrue(items.contains(item));
    }

    @Test
    public void testUpdate() {
        var item = itemService.GetById(1L);
        item.setName("Test updated");
        itemService.Update(item);

        var updatedItem = itemService.GetById(1L);

        assertNotNull(item);
        assertEquals(1L, updatedItem.getId());
        assertEquals("Test updated", updatedItem.getName());
    }

    @Test
    public void testDelete() {
        var item = itemService.GetById(1L);
        itemService.Delete(item.getId());

        var deletedItem = itemService.GetById(item.getId());

        assertNull(deletedItem);
    }
}
