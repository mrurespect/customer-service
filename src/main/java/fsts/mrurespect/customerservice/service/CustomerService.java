package fsts.mrurespect.customerservice.service;


import fsts.mrurespect.customerservice.dto.CustomerRequestDto;
import fsts.mrurespect.customerservice.entity.Customer;
import fsts.mrurespect.customerservice.exception.customer.CustumerNotFoundException;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id) throws CustumerNotFoundException;
    Customer addCustomer(CustomerRequestDto customer);
    Customer updateCustomer(Customer customer) throws CustumerNotFoundException;
    boolean deleteCustomer(String id) throws CustumerNotFoundException;
}
