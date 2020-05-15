package com.clyde.uber.db.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "driver")
public class DriverEntity extends UberEntity {
    private String name;
    private String phoneNumber;
}
