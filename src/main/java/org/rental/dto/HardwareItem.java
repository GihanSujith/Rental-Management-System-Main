package org.rental.dto;

import lombok.Data;

@Data
public class HardwareItem {
    private Integer itemId;
    private String name;
    private String rentalPerDay;
    private String finrPerDay;
    private String availability;
}
