package com.clyde.uber.db.controllers;

import com.clyde.uber.db.services.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms-payment")
public class PaymentInfoController {

    private PaymentInfoService paymentInfoService;

    @Autowired
    public PaymentInfoController(PaymentInfoService paymentInfoService) {
        this.paymentInfoService = paymentInfoService;
    }

    @GetMapping("/for-driver/{driverId}")
    public ResponseEntity paymentsForDriver(
            @PathVariable("driverId")Long  driverId) throws Exception {
        return new ResponseEntity(paymentInfoService.getPaymentsForDriver(driverId), HttpStatus.OK);
    }

    @GetMapping("/for-trip/{tripId}")
    public ResponseEntity paymentsForTrip(
            @PathVariable("tripId")Long  tripId) throws Exception {
        return new ResponseEntity(paymentInfoService.getPaymentsForTrip(tripId), HttpStatus.OK);
    }

    @GetMapping("/driver-avg/{driverId}")
    public ResponseEntity averageTripPriceForDriver(
            @PathVariable("driverId")Long  driverId) throws Exception {
        return new ResponseEntity(paymentInfoService.averageTripPriceForDriver(driverId), HttpStatus.OK);
    }

}
