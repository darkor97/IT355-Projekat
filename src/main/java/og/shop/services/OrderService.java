package og.shop.services;

import og.shop.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> GetAll();

    Order GetById(Long orderId);

    Order Add(Order order);

    Order Update(Order order);

    void Delete(Long orderId);
}
