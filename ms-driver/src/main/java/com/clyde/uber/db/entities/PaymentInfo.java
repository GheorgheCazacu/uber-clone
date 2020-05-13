package com.clyde.uber.db.entities;

import lombok.*;

import java.sql.Timestamp;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class PaymentInfo extends UberEntity{
    private double price;
    private Timestamp start;
    private Timestamp end;
    private Long tripId;
}
