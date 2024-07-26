package org.rental.service;

import org.rental.dto.Rental;

import java.util.List;

public interface RentalService {
    Rental createRental(Rental rental);

    List<Rental> retriveRental();

    void deleteRentalById(Integer rentalId);

    void updateRental(Rental rental);

}
