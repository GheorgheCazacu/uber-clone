package com.clyde.uber.api.model.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Driver {
        private Long id;
        private String name;
        private String phoneNumber;
        private double avgTripPrice;
}