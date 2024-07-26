package org.rental.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item")
@Setter
@Getter
public class HardwareItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;
    private String name;
    private String rentalPerDay;
    private String finrPerDay;
    private String availability;
}
