package com.clyde.uber.db.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UberEntity implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Override
    public boolean isNew() {
        return id == null;
    }

}
