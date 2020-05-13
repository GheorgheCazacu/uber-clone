package com.clyde.uber.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class PaymentInfo extends UberEntity{
    private double price;
    private Timestamp start;
    private Timestamp end;
    private Long tripId;
}
