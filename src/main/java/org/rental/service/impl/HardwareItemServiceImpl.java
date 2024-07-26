package org.rental.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rental.dto.HardwareItem;
import org.rental.entity.HardwareItemEntity;
import org.rental.repository.HardwareRepository;
import org.rental.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<HardwareItem> retriveHardwareItem() {
        final Iterable<HardwareItemEntity> allHardwareItem = repository.findAll();

        List<HardwareItem> hardwareItemList = new ArrayList<>();
        
        allHardwareItem.forEach(hardwareItemEntity -> {
            hardwareItemList.add(
                    mapper.convertValue(HardwareItemEntity, HardwareItem.class));
        });
        return hardwareItemList;
    }

    @Override
    public void deleteHardwareItemById(Integer itemId) {
        if (repository.existsById(itemId)){
            repository.deleteById(itemId);
        }
    }

    @Override
    public void updateHardwareItem(HardwareItem hardwareItem) {
        if (repository.findById(hardwareItem.getItemId()).isPresent()){
            repository.save(new ObjectMapper().convertValue(hardwareItem,HardwareItemEntity.class));
        }
    }
}
