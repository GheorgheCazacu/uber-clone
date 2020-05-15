package com.clyde.payment.services;

import com.clyde.payment.persistances.PaymentServerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentServerService {

    private PaymentServerRepository paymentServerRepository;
    public PaymentServerService(PaymentServerRepository paymentServerRepository) {
        this.paymentServerRepository = paymentServerRepository;
    }


}
