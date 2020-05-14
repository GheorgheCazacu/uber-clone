package com.clyde.uber.db.services;

import com.clyde.uber.db.dto.TripDTO;
import com.clyde.uber.db.entities.Trip;
import com.clyde.uber.db.exceptions.NotFoundException;
import com.clyde.uber.db.repositories.TripRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TripService {

    private TripRepository tripRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public TripDTO getTrip(Long id) throws NotFoundException{
        Optional<Trip> trip = tripRepository.findById(id);
        if(!trip.isPresent()) {
            throw new NotFoundException("no driver for id: " + id);
        }
        TripDTO tripDTO = modelMapper.map(trip.get(), TripDTO.class);
        return tripDTO;
    }

    public Set<TripDTO> getDriverTrips(Long driverId) {
        Set<Trip> trips = tripRepository.findByDriverId(driverId);
        return trips
                .stream()
                .map(trip -> modelMapper.map(trip, TripDTO.class))
                .collect(Collectors.toSet());
    }
}
