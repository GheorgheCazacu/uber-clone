package com.clyde.uber.db.services;

import com.clyde.uber.db.dto.VehicleDTO;
import com.clyde.uber.db.entities.Vehicle;
import com.clyde.uber.db.exceptions.NotFoundException;
import com.clyde.uber.db.repositories.VehicleRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
public class VehicleService {
    private VehicleRepository vehicleRepository;
    private ModelMapper modelMapper = new ModelMapper();

//    Converter<Timestamp, LocalDateTime> toStringDate = new AbstractConverter<Timestamp, LocalDateTime>() {
//        @Override
//        protected LocalDateTime convert(Timestamp source) {
//
//            LocalDateTime localDate = LocalDateTime.from(source.getTime());
//            return localDate;
//        }
//    };


    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @PostConstruct
    private void postConstruct() {
        modelMapper.getTypeMap(Timestamp.class, LocalDateTime.class); // no provider, maps ok with me still
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


    public VehicleDTO getVehicle(Long id) throws NotFoundException {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(!vehicle.isPresent()) {
            throw new NotFoundException("vehicle not found for id: " + id);
        }
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

}
