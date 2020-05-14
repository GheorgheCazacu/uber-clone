package com.clyde.uber.db.controllers;

import com.clyde.uber.db.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms-trip")
public class TripController {

    private TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/trip/{id}")
    public ResponseEntity getTrip(@PathVariable("id")Long  id) throws Exception {
        return new ResponseEntity(tripService.getTrip(id), HttpStatus.OK);
    }

    @GetMapping("/driver-trips/{driverId}")
    public ResponseEntity getDriverTrips(@PathVariable("driverId")Long  driverId) throws Exception {
        return new ResponseEntity(tripService.getDriverTrips(driverId), HttpStatus.OK);
    }


}
