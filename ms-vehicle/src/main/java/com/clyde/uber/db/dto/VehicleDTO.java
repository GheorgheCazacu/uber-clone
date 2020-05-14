package com.clyde.uber.db.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class VehicleDTO {
    private Long id;
    private String name;
    private String color;
    private String registrationNumber;
    private LocalDateTime registerTimestamp;
}
