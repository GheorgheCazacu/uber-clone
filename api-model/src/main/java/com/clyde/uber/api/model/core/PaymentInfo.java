package com.clyde.uber.api.model.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PaymentInfo {
    private Long id;
    private double price;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long tripId;
    private Long driverId;
}
