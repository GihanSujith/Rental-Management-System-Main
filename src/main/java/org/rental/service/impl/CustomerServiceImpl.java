package org.rental.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rental.dto.Customer;
import org.rental.entity.CustomerEntity;
import org.rental.repository.CustomerRepository;
import org.rental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Customer> retriveCustomer() {
        final Iterable<CustomerEntity> allCustomer = repository.findAll();

        List<Customer> customerList = new ArrayList<>();

        allCustomer.forEach(customerEntity -> {
            customerList.add(
                    mapper.convertValue(customerEntity, Customer.class));
        });
        return customerList;
    }

    @Override
    public void deleteCudtomerById(Integer customerId) {
        if (repository.existsById(customerId)){
            repository.deleteById(customerId);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (repository.findById(customer.getCustomerId()).isPresent()){
            repository.save(new ObjectMapper().convertValue(customer,CustomerEntity.class));
        }
    }
}
