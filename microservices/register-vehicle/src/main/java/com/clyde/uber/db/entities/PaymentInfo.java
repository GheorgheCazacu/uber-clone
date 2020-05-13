package com.clyde.uber.db.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@Entity
public class PaymentInfo extends UberEntity{

    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "start", nullable = false)
    private Timestamp start;
    @Column(name = "end", nullable = true)
    private Timestamp end;

}
