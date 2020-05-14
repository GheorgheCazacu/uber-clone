package com.clyde.uber.db.exceptions;

import lombok.NoArgsConstructor;

public class NotFoundException extends Exception {
    public NotFoundException(String msg) {
        super(msg);
    }
}
