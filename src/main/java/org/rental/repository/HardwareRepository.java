package org.rental.repository;

import org.rental.entity.HardwareItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface HardwareRepository extends CrudRepository<HardwareItemEntity,Integer> {
}
