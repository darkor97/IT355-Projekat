package og.shop.controllers;

import og.shop.models.Receipt;
import og.shop.services.ReceiptService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReceiptTests {

    private ReceiptService receiptService;
    private ReceiptController receiptController;

    @Before
    public void init() {
        receiptService = Mockito.mock(ReceiptService.class);
        receiptController = new ReceiptController(receiptService);
    }

    @Test
    public void testsAll() {
        Mockito.when(receiptService.GetAll()).thenReturn(Arrays.asList(new Receipt(), new Receipt(), new Receipt()));

        var res = receiptController.All();

        assertNotNull(res);
        assertEquals(3, res.getBody().size());
    }

    @Test
    public void testById() {
        var receipt = new Receipt();
        receipt.setId(0L);
        Mockito.when(receiptService.GetById(0L)).thenReturn(receipt);

        var res = receiptController.GetById(0L);

        assertNotNull(res);
        assertEquals(0L, res.getBody().getId());
    }

    @Test
    public void testCreate() {
        var receipt = new Receipt();
        receipt.setTotal(5.0);
        var receiptToReturn = new Receipt();
        receiptToReturn.setTotal(receipt.getTotal());
        receiptToReturn.setId(1L);
        Mockito.when(receiptService.Add(receipt)).thenReturn(receiptToReturn);

        var res = receiptController.Create(receipt);

        assertNotNull(res);
        assertEquals(1, res.getBody().getId());
        assertEquals(5.0, res.getBody().getTotal());
    }

    @Test
    public void testUpdate() {
        var receipt = new Receipt();
        receipt.setTotal(5.0);
        var receiptToReturn = new Receipt();
        receiptToReturn.setTotal(5.0);
        receiptToReturn.setId(1L);
        Mockito.when(receiptService.Update(receipt)).thenReturn(receiptToReturn);

        var res = receiptController.Update(receipt);

        assertNotNull(res);
        assertEquals(1, res.getBody().getId());
        assertEquals(5.0, res.getBody().getTotal());
    }

    @Test
    public void testDelete() {
        Mockito.doNothing().when(receiptService).Delete(0L);

        var res = receiptController.Delete(0L);

        assertNotNull(res);
        assertEquals(200, res.getStatusCode().value());
    }
}
