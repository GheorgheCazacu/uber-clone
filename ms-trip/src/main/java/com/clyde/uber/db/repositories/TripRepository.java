package com.clyde.uber.db.repositories;

import com.clyde.uber.db.entities.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, Long> {
    Set<TripEntity> findByDriverId(Long driverId);
}
