package og.shop.controllers;

import lombok.RequiredArgsConstructor;
import og.shop.models.Item;
import og.shop.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("item")
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/all")
    public ResponseEntity<List<Item>> All() {
        return ResponseEntity.ok(itemService.GetAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> GetById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.GetById(id));
    }

    @PostMapping()
    public ResponseEntity<Item> Create(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.Add(item));
    }

    @PutMapping()
    public ResponseEntity<Item> Update(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.Update(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> Delete(@PathVariable Long id) {
        itemService.Delete(id);
        return ResponseEntity.ok().build();
    }
}