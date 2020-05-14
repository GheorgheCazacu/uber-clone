package com.clyde.uber.db.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DriverDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private double avgTripPrice;
}
