package com.clyde.uber.db.repositories;

import com.clyde.uber.db.entities.PaymentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfoEntity, Long> {

    @Query(value = "select avg(sum_table.s) from \n" +
            "(select p.trip_id, sum(p.paid_price) as s from payment p where p.driver_id = :driverId" +
            " group by p.trip_id) as sum_table", nativeQuery = true)
    Optional<Double> retrieveDriverAverageTripPrice(Long driverId);

    Set<PaymentInfoEntity> findByDriverId(Long driverId);
    Set<PaymentInfoEntity> findByTripId(Long tripId);

}
