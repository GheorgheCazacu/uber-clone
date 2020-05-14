package com.clyde.uber.db.services;

import com.clyde.uber.db.dto.PaymentInfoDTO;
import com.clyde.uber.db.entities.PaymentInfo;
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

    public Set<PaymentInfoDTO> getPaymentsForTrip(Long tripId) {

        Set<PaymentInfo> result = paymentInfoRepository.findByTripId(tripId);
        return mappToDTO(result);
    }

    public Set<PaymentInfoDTO> getPaymentsForDriver(Long driverId) {

        Set<PaymentInfo> result = paymentInfoRepository.findByDriverId(driverId);
        return mappToDTO(result);
    }

    public double averageTripPriceForDriver(Long driverId) {
        Optional<Double> result = paymentInfoRepository.retrieveDriverAverageTripPrice(driverId);
        return (result.isPresent() ? 0.0d : result.get());
    }

    private Set<PaymentInfoDTO> mappToDTO(Set<PaymentInfo> infos) {
        return infos
                .stream()
                .map(paymentInfo -> modelMapper.map(paymentInfo, PaymentInfoDTO.class))
                .collect(Collectors.toSet());
    }

}
