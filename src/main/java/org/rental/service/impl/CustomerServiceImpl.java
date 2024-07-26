package org.rental.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rental.dto.Customer;
import org.rental.entity.CustomerEntity;
import org.rental.repository.CustomerRepository;
import org.rental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    CustomerRepository repository;
    
    @Autowired
    ObjectMapper mapper;
    
    @Override
    public Customer createCustomer(Customer customer) {

        CustomerEntity customerEntity
                = mapper.convertValue(customer, CustomerEntity.class);

        CustomerEntity savedCustomer = repository.save(customerEntity);

        customer.setCustomerId(savedCustomer.getCustomerId());

        return customer;
    }
}
