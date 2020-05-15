package com.clyde.uber.db.services;

import com.clyde.uber.api.exceptions.NotFoundException;
import com.clyde.uber.api.model.core.Trip;
import com.clyde.uber.db.entities.TripEntity;
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

    public Trip getTrip(Long id) throws NotFoundException {
        Optional<TripEntity> trip = tripRepository.findById(id);
        if(!trip.isPresent()) {
            throw new NotFoundException("no driver for id: " + id);
        }
        Trip tripDTO = modelMapper.map(trip.get(), Trip.class);
        return tripDTO;
    }

    public Set<Trip> getDriverTrips(Long driverId) {
        Set<TripEntity> trips = tripRepository.findByDriverId(driverId);
        return trips
                .stream()
                .map(trip -> modelMapper.map(trip, Trip.class))
                .collect(Collectors.toSet());
    }
}
