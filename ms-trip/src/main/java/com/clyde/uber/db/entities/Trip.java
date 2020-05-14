package com.clyde.uber.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Trip extends UberEntity {
    private String start;
    private String end;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long driverId;
}
