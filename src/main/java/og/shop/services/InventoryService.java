package og.shop.services;

import og.shop.models.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> GetAll();

    Inventory GetById(Long inventoryId);

    Inventory Add(Inventory inventory);

    Inventory Update(Inventory inventory);

    void Delete(Long inventoryId);
}
