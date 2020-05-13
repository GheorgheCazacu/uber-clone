package com.clyde.uber.db.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Builder
@Entity
public class Vehicle extends UberEntity {

    private String name;
    private String color;
    private String registrationNumber;
    private Long registerTimeStamp;

}
