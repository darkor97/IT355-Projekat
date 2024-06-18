package og.shop.controllers;

import lombok.RequiredArgsConstructor;
import og.shop.models.Inventory;
import og.shop.services.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> All() {
        return ResponseEntity.ok(inventoryService.GetAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> GetById(@PathVariable Long id) {
        return ResponseEntity.ok(inventoryService.GetById(id));
    }

    @PostMapping()
    public ResponseEntity<Inventory> Create(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.Add(inventory));
    }

    @PutMapping()
    public ResponseEntity<Inventory> Update(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.Update(inventory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Inventory> Delete(@PathVariable Long id) {
        inventoryService.Delete(id);
        return ResponseEntity.ok().build();
    }
}