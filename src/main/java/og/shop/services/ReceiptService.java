package og.shop.services;

import og.shop.models.Receipt;

import java.util.List;

public interface ReceiptService {
    List<Receipt> GetAll();

    Receipt GetById(Long receiptId);

    Receipt Add(Receipt receipt);

    Receipt Update(Receipt receipt);

    void Delete(Long receiptId);
}
