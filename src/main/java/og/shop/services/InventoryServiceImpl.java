package og.shop.services;

import lombok.RequiredArgsConstructor;
import og.shop.models.Inventory;
import og.shop.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> GetAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory GetById(Long inventoryId) {
        return inventoryRepository.findById(inventoryId).orElse(null);
    }

    @Override
    public Inventory Add(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory Update(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void Delete(Long inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }
}
