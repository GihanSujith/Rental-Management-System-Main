package org.rental.dto;

import lombok.Data;

@Data
public class Rental {
    private Integer rentalId;
    private String rentalDate;
    private String returnDate;
    private String dueDate;
    private String expetDate;
    private String fine;
    private Double totalCost;
}
