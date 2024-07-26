package org.rental.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rental.dto.HardwareItem;
import org.rental.entity.HardwareItemEntity;
import org.rental.repository.HardwareRepository;
import org.rental.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardwareItemServiceImpl implements HardwareService {

    @Autowired
    HardwareRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public HardwareItem createHardwareItem(HardwareItem hardwareItem) {

        HardwareItemEntity hardwareItemEntity
                = mapper.convertValue(hardwareItem, HardwareItemEntity.class);

        HardwareItemEntity savedHardwareItem = repository.save(hardwareItemEntity);

        hardwareItem.setItemId(savedHardwareItem.getItemId());

        return hardwareItem;
    }
}
