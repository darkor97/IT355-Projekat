package og.shop.services;

import og.shop.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> GetAll();

    Item GetById(Long itemId);

    Item Add(Item item);

    Item Update(Item item);

    void Delete(Long itemId);
}
