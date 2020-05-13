package com.clyde.uber.db.services;

import com.clyde.uber.db.dto.DriverDTO;
import com.clyde.uber.db.dto.VehicleDTO;
import com.clyde.uber.db.entities.Driver;
import com.clyde.uber.db.entities.Vehicle;
import com.clyde.uber.db.exceptions.NotFoundException;
import com.clyde.uber.db.repositories.VehicleRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     *
     * @param id driver id
     * @return
     * @throws NotFoundException
     */
    public Set<VehicleDTO> getVehiclesForDriver(Long id) throws NotFoundException {
        Set<Vehicle> vehicles = vehicleRepository.findByDriverId(id);

        return vehicles
                .stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class))
                .collect(Collectors.toSet());
    }

}
