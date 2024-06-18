package og.shop.controllers;

import lombok.RequiredArgsConstructor;
import og.shop.models.Item;
import og.shop.models.Receipt;
import og.shop.services.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("item")
public class ReceiptController {
    private final ReceiptService receiptService;

    @GetMapping("/all")
    public ResponseEntity<List<Receipt>> All() {
        return ResponseEntity.ok(receiptService.GetAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receipt> GetById(@PathVariable Long id) {
        return ResponseEntity.ok(receiptService.GetById(id));
    }

    @PostMapping()
    public ResponseEntity<Receipt> Create(@RequestBody Receipt receipt) {
        return ResponseEntity.ok(receiptService.Add(receipt));
    }

    @PutMapping()
    public ResponseEntity<Receipt> Update(@RequestBody Receipt receipt) {
        return ResponseEntity.ok(receiptService.Update(receipt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> Delete(@PathVariable Long id) {
        receiptService.Delete(id);
        return ResponseEntity.ok().build();
    }
}