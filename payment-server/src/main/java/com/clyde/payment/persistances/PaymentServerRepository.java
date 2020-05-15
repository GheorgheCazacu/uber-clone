package com.clyde.payment.persistances;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentServerRepository extends JpaRepository<PaymentServer, Long> {
}
