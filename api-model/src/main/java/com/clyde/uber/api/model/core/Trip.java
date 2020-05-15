package com.clyde.uber.api.model.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Trip {
    private Long id;
    private String start;
    private String end;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long driverId;
}
