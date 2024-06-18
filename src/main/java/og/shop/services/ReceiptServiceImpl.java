package og.shop.services;

import lombok.RequiredArgsConstructor;
import og.shop.models.Receipt;
import og.shop.repositories.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository receiptRepository;

    public List<Receipt> GetAll() {
        return receiptRepository.findAll();
    }

    @Override
    public Receipt GetById(Long receiptId) {
        return receiptRepository.findById(receiptId).orElse(null);
    }

    @Override
    public Receipt Add(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public Receipt Update(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public void Delete(Long receiptId) {
        receiptRepository.deleteById(receiptId);
    }
}

