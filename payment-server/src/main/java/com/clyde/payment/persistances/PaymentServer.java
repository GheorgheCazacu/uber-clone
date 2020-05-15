package com.clyde.payment.persistances;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "payment_server")
public class PaymentServer extends UberEntity {
    private String name;
    private String phoneNumber;
}
