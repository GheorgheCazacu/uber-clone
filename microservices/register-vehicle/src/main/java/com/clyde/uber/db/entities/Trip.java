package com.clyde.uber.db.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class Trip extends UberEntity {
    @Column(name = "start", nullable = false)
    private String start;
    @Column(name = "end", nullable = false)
    private String end;

}
