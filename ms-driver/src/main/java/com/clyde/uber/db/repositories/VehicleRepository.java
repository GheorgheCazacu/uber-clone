package com.clyde.uber.db.repositories;

import com.clyde.uber.db.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    public Set<Vehicle> findByDriverId(Long id);
}
