package org.rental.service;

import org.rental.dto.HardwareItem;

import java.util.List;

public interface HardwareService {
    HardwareItem createHardwareItem(HardwareItem hardwareItem);

    List<HardwareItem> retriveHardwareItem();

}
