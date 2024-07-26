package org.rental.repository;

import org.rental.entity.RentalEntity;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<RentalEntity,Integer> {
}
