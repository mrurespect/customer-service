package fsts.mrurespect.customerservice.service;



import fsts.mrurespect.customerservice.dto.CustomerRequestDto;
import fsts.mrurespect.customerservice.entity.Customer;
import fsts.mrurespect.customerservice.exception.customer.CustumerNotFoundException;
import fsts.mrurespect.customerservice.mapper.CustomerMapper;
import fsts.mrurespect.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) throws CustumerNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustumerNotFoundException(String.format("Customer with ID  %s not found", id)));
    }

    @Override
    public Customer addCustomer(CustomerRequestDto customer) {
        return customerRepository.save(CustomerMapper.toCustomer(customer));
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustumerNotFoundException {
        if (customerRepository.findById(customer.getId()).isEmpty()) {
            throw new CustumerNotFoundException(String.format("Customer with ID  %s not found", customer.getId()));
        }

        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(String id) throws CustumerNotFoundException {
        try {
            customerRepository.deleteById(Long.parseLong(id));
        } catch (Exception e) {
            throw new CustumerNotFoundException(String.format("Customer with ID  %s not found", id));
        }
        return true;
    }
}
