package org.rental.controller;

import org.rental.dto.HardwareItem;
import org.rental.service.HardwareService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hardwareItem")
@CrossOrigin
public class HardwareController {

    HardwareService service;

    HardwareController(HardwareService service){
        this.service = service;
    }

    @PostMapping()
    HardwareItem save(@RequestBody HardwareItem hardwareItem){
       return service.createHardwareItem(hardwareItem);
    }

}
