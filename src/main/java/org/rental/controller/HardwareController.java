package org.rental.controller;

import org.rental.dto.HardwareItem;
import org.rental.service.HardwareService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    List<HardwareItem> retrive(){
        return service.retriveHardwareItem();
    }

    @DeleteMapping("/delete-hard/{itemId}")
    public String delete(@PathVariable Integer itemId){
        service.deleteHardwareItemById(itemId);
        return "deleted";
    }

    @PutMapping()
    public void update(@RequestBody HardwareItem hardwareItem){
        service.updateHardwareItem(hardwareItem);
    }

}
