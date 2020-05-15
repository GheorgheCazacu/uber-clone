package com.clyde.uber.db.repositories;

import com.clyde.uber.db.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    public Set<VehicleEntity> findByDriverId(Long id);
}
