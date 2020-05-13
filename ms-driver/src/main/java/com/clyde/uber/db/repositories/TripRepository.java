package com.clyde.uber.db.repositories;

import com.clyde.uber.db.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query(value = "select avg(sum_table.s) from " +
            "(select t.id, sum(p.paid_price) as s from payment p left join trip t on p.trip_id=t.id " +
            "where t.driver_id = :driverId group by t.id)\n" +
            "as sum_table;", nativeQuery = true)
    Optional<Double> retrieveDriverAverageTripPrice(Long driverId);
}
