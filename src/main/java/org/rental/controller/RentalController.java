package org.rental.controller;


import org.rental.dto.Rental;
import org.rental.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
@CrossOrigin
public class RentalController {

    RentalService service;

    RentalController(RentalService service){
        this.service = service;
    }

    @PostMapping()
    Rental save(@RequestBody Rental rental){
        return service.createRental(rental);
    }

    @GetMapping ()
    List<Rental> retrive(){
        return service.retriveRental();
    }

    @DeleteMapping("/delete-rent/{rentalId}")
    public String delete(@PathVariable Integer rentalId){
        service.deleteRentalById(rentalId);
        return "deleted";
    }
}
