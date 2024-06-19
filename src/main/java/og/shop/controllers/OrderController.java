package og.shop.controllers;

import lombok.RequiredArgsConstructor;
import og.shop.models.Item;
import og.shop.models.Order;
import og.shop.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> All() {
        return ResponseEntity.ok(orderService.GetAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> GetById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.GetById(id));
    }

    @PostMapping()
    public ResponseEntity<Order> Create(@RequestBody Order receipt) {
        return ResponseEntity.ok(orderService.Add(receipt));
    }

    @PutMapping()
    public ResponseEntity<Order> Update(@RequestBody Order receipt) {
        return ResponseEntity.ok(orderService.Update(receipt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> Delete(@PathVariable Long id) {
        orderService.Delete(id);
        return ResponseEntity.ok().build();
    }
}