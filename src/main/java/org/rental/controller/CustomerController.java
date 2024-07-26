package org.rental.controller;

import org.rental.dto.Customer;
import org.rental.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    final CustomerService service;

    CustomerController(CustomerService service){
        this.service = service;
    }

    @PostMapping()
    Customer save(@RequestBody Customer customer){
       return service.createCustomer(customer);
    }
}
