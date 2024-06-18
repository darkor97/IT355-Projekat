package og.shop.controllers;

import lombok.RequiredArgsConstructor;
import og.shop.services.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/all")
    public String All() {
        return "all";
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<City> GetById(@PathVariable Long id) {
//        return ResponseEntity.ok(cityService.GetById(id));
//    }
//
//    @PostMapping()
//    public ResponseEntity<City> CreateCity(@RequestBody City city) {
//        return ResponseEntity.ok(cityService.Add(city));
//    }
//
//    @PutMapping()
//    public ResponseEntity<City> UpdateCity(@RequestBody City city) {
//
//        return ResponseEntity.ok(cityService.Update(city));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<City> DeleteCity(@PathVariable Long id) {
//        cityService.Delete(id);
//        return ResponseEntity.ok().build();
//    }
}