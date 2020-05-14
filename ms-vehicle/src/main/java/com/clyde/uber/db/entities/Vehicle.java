package com.clyde.uber.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Vehicle extends UberEntity {
    private String name;
    private String color;
    private String registrationNumber;
    private LocalDateTime registerTimestamp;
    private String active;
    private Long driverId;
}
