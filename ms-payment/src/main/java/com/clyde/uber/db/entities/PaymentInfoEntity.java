package com.clyde.uber.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "payment_info")
public class PaymentInfoEntity extends UberEntity{
    private double price;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long tripId;
    private Long driverId;
}
