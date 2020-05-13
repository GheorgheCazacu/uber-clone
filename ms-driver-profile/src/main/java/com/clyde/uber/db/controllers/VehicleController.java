package com.clyde.uber.db.controllers;

import com.clyde.uber.db.services.DriverService;
import com.clyde.uber.db.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms-driver")
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity getDriver(@PathVariable("id")Long  id) throws Exception {
        return new ResponseEntity(vehicleService.getVehiclesForDriver(id), HttpStatus.OK);
    }


}
