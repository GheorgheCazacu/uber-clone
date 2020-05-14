package com.clyde.uber.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class PaymentInfo extends UberEntity{
    private double price;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long tripId;
    private Long driverId;
}
