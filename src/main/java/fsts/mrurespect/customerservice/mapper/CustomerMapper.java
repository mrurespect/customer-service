package fsts.mrurespect.customerservice.mapper;

import fsts.mrurespect.customerservice.dto.CustomerRequestDto;
import fsts.mrurespect.customerservice.entity.Customer;
import org.springframework.beans.BeanUtils;

public class CustomerMapper {
    public static Customer toCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerRequestDto, customer);
        return customer;
    }
}
