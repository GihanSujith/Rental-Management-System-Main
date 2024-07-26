package org.rental.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rental.dto.Rental;
import org.rental.entity.RentalEntity;
import org.rental.repository.RentalRepository;
import org.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    RentalRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Rental createRental(Rental rental) {

        RentalEntity rentalEntity
                = mapper.convertValue(rental, RentalEntity.class);

        RentalEntity savedRent = repository.save(rentalEntity);

        rental.setRentalId(savedRent.getRentalId());
        return rental;
    }
}
