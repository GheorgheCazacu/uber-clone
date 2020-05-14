package com.clyde.uber.db.repositories;

import com.clyde.uber.db.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    Set<Trip> findByDriverId(Long driverId);
}
