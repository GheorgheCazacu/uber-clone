package com.clyde.uber.db.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
public class Vehicle extends UberEntity {
    private String name;
    private String color;
    private String registrationNumber;
    private Long registerTimestamp;
    private String active;
    private Long driverId;
}
