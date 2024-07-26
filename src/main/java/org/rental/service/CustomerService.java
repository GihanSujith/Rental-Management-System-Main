package org.rental.service;

import org.rental.dto.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    List<Customer> retriveCustomer();

}
