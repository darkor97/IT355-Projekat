package og.shop.services;

import og.shop.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> GetAll();

    Customer GetById(Long userId);

    Customer Add(Customer user);

    Customer Update(Customer user);

    void Delete(Long userId);
}
