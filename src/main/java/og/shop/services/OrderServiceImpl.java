package og.shop.services;

import lombok.RequiredArgsConstructor;
import og.shop.models.Order;
import og.shop.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final InventoryService inventoryService;

    public List<Order> GetAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order GetById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public Order Add(Order order) {
        for (var item : order.getItems()) {
            var state = inventoryService.GetById(item.getId());
            state.setNumberOfItems(state.getNumberOfItems() + 1);
            inventoryService.Update(state);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order Update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void Delete(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
