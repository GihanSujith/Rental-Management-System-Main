package org.rental.dto;

import lombok.Data;

@Data
public class Customer {
    private Integer customerId;
    private String name;
    private String city;
    private String contact;
}
