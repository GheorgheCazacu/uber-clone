package com.clyde.uber.db.services;

import com.clyde.uber.api.model.core.PaymentInfo;
import com.clyde.uber.db.entities.PaymentInfoEntity;
import com.clyde.uber.db.repositories.PaymentInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PaymentInfoService {

    private PaymentInfoRepository paymentInfoRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public PaymentInfoService(PaymentInfoRepository paymentInfoRepository) {
        this.paymentInfoRepository = paymentInfoRepository;
    }

    public Set<PaymentInfo> getPaymentsForTrip(Long tripId) {

        Set<PaymentInfoEntity> result = paymentInfoRepository.findByTripId(tripId);
        return mappToDTO(result);
    }

    public Set<PaymentInfo> getPaymentsForDriver(Long driverId) {

        Set<PaymentInfoEntity> result = paymentInfoRepository.findByDriverId(driverId);
        return mappToDTO(result);
    }

    public double averageTripPriceForDriver(Long driverId) {
        Optional<Double> result = paymentInfoRepository.retrieveDriverAverageTripPrice(driverId);
        return (result.isPresent() ? 0.0d : result.get());
    }

    private Set<PaymentInfo> mappToDTO(Set<PaymentInfoEntity> infos) {
        return infos
                .stream()
                .map(paymentInfoEntity -> modelMapper.map(paymentInfoEntity, PaymentInfo.class))
                .collect(Collectors.toSet());
    }

}
