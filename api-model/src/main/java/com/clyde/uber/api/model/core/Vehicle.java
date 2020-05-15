package com.clyde.uber.api.model.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
    private Long id;
    private String name;
    private String color;
    private String registrationNumber;
    private LocalDateTime registerTimestamp;
}
