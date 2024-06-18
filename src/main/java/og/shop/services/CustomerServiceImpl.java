package og.shop.services;

import lombok.RequiredArgsConstructor;
import og.shop.models.Customer;
import og.shop.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final UserRepository userRepository;

    public List<Customer> GetAll() {
        return userRepository.findAll();
    }

    @Override
    public Customer GetById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Customer Add(Customer user) {
        return userRepository.save(user);
    }

    @Override
    public Customer Update(Customer user) {
        return userRepository.save(user);
    }

    @Override
    public void Delete(Long userId) {
        userRepository.deleteById(userId);
    }
}

