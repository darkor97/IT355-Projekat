package og.shop.services;

import lombok.RequiredArgsConstructor;
import og.shop.models.Inventory;
import og.shop.models.Item;
import og.shop.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public List<Item> GetAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item GetById(Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    @Override
    public Item Add(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item Update(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void Delete(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
