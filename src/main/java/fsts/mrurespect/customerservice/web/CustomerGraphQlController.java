package fsts.mrurespect.customerservice.web;



import fsts.mrurespect.customerservice.dto.CustomerRequestDto;

import fsts.mrurespect.customerservice.entity.Customer;

import fsts.mrurespect.customerservice.exception.customer.CustumerNotFoundException;
import fsts.mrurespect.customerservice.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graphql")
public class CustomerGraphQlController {
    private final CustomerService customerService;

    public CustomerGraphQlController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
    public List<Customer> customerList() {
        return customerService.getAllCustomers();
    }
    @QueryMapping
    public Customer customer(@Argument  Long  id) throws CustumerNotFoundException {
        return customerService.getCustomerById(id);
    }
    @MutationMapping
    public Customer addCustomer(@Argument CustomerRequestDto customer){
        return customerService.addCustomer(customer);
    }
    @MutationMapping
    public Customer updateCustomer(@Argument Customer customer) throws CustumerNotFoundException {
        return customerService.updateCustomer(customer);
    }
    @MutationMapping
    public boolean deleteCustomer(@Argument String id) throws CustumerNotFoundException {
        return customerService.deleteCustomer(id);
    }
    //@MutationMapping
    //public Customer addAccountToCustomer(@Argument Long customerId, @Argument String accountId) throws CustumerNotFoundException, AccountNotFoundException {
    //    Customer customer = customerService.getCustomerById(customerId);
    //    Account account = accountService.getAccountById(accountId);
    //    account.setCustomer(customer);
    //    customer.getAccounts().add(account);
    //    customerService.updateCustomer(customer);
    //    accountService.updateAccount(account);
    //    return customer;
    //}
}
