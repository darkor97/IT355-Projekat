package og.shop.controllers;

import lombok.RequiredArgsConstructor;
import og.shop.models.Customer;
import og.shop.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> All() {
        return ResponseEntity.ok(customerService.GetAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> GetById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.GetById(id));
    }

    @PostMapping()
    public ResponseEntity<Customer> Create(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.Add(customer));
    }

    @PutMapping()
    public ResponseEntity<Customer> Update(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.Update(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> Delete(@PathVariable Long id) {
        customerService.Delete(id);
        return ResponseEntity.ok().build();
    }
}