package com.clyde.uber.db.services;

import com.clyde.uber.api.exceptions.NotFoundException;
import com.clyde.uber.api.model.core.Vehicle;
import com.clyde.uber.db.entities.VehicleEntity;
import com.clyde.uber.db.repositories.VehicleRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
public class VehicleService {
    private VehicleRepository vehicleRepository;
    private ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @PostConstruct
    private void postConstruct() {
        modelMapper.getTypeMap(Timestamp.class, LocalDateTime.class); // no provider, maps ok with me still
    }

    public Set<Vehicle> getVehiclesForDriver(Long id) throws NotFoundException {
        Set<VehicleEntity> vehicleEntities = vehicleRepository.findByDriverId(id);

        return vehicleEntities
                .stream()
                .map(vehicle -> modelMapper.map(vehicle, Vehicle.class))
                .collect(Collectors.toSet());
    }


    public Vehicle getVehicle(Long id) throws NotFoundException {
        Optional<VehicleEntity> vehicle = vehicleRepository.findById(id);
        if(!vehicle.isPresent()) {
            throw new NotFoundException("vehicle not found for id: " + id);
        }
        return modelMapper.map(vehicle.get(), Vehicle.class);
    }

}
