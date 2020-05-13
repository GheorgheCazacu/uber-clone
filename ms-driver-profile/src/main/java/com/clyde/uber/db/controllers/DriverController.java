package com.clyde.uber.db.controllers;

import com.clyde.uber.db.repositories.TripRepository;
import com.clyde.uber.db.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms-driver")
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/driver/{id}")
    public ResponseEntity getDriver(@PathVariable("id")Long  id) throws Exception {
        return new ResponseEntity(driverService.getDriver(id), HttpStatus.OK);
    }

}
