package com.clyde.uber.db.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Trip extends UberEntity {
    private String start;
    private String end;
    private Long driverId;
}
