package com.clyde.uber.db.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TripDTO {
    private Long id;
    private String start;
    private String end;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long driverId;
}
