package com.clyde.uber.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class VehicleEntity extends UberEntity {
    private String name;
    private String color;
    private String registrationNumber;
    private LocalDateTime registerTimestamp;
    private String active;
    private Long driverId;
}
