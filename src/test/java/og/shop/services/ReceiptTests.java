package og.shop.services;

import og.shop.ShopApplication;
import og.shop.models.Receipt;
import og.shop.services.ReceiptService;
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
public class ReceiptTests {
    @Autowired
    private ReceiptService receiptService;

    @BeforeEach
    public void init() {
        var receipt = new Receipt();
        receipt.setTotal(5.0);
        receiptService.Add(receipt);
    }

    @Test
    public void testGetById() {
        var receipt = receiptService.GetById(1L);
        assertNotNull(receipt);
        assertEquals(1L, receipt.getId());
        assertEquals(5.0, receipt.getTotal());
    }

    @Test
    public void testGetAll() {
        var receipt = receiptService.GetById(1L);
        var receipts = receiptService.GetAll();
        assertNotNull(receipts);
        assertFalse(receipts.isEmpty());
        assertTrue(receipts.contains(receipt));
    }

    @Test
    public void testUpdate() {
        var receipt = receiptService.GetById(1L);
        receiptService.Update(receipt);

        var updatedReceipt = receiptService.GetById(1L);

        assertNotNull(receipt);
        assertEquals(1L, updatedReceipt.getId());
        assertEquals(5.0, updatedReceipt.getTotal());
    }

    @Test
    public void testDelete() {
        var receipt = receiptService.GetById(1L);
        receiptService.Delete(receipt.getId());

        var deletedReceipt = receiptService.GetById(receipt.getId());

        assertNull(deletedReceipt);
    }
}
