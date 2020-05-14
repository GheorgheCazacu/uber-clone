package com.clyde.uber.db.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PaymentInfoDTO {
    private Long id;
    private double price;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long tripId;
    private Long driverId;
}
