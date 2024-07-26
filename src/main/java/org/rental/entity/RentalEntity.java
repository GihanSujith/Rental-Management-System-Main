package org.rental.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rental")
@Setter
@Getter
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rentalId;
    private String rentalDate;
    private String returnDate;
    private String dueDate;
    private String expetDate;
    private String fine;
    private Double totalCost;
}
