package com.clyde.uber.db.services;

import com.clyde.uber.db.dto.DriverDTO;
import com.clyde.uber.db.entities.Driver;
import com.clyde.uber.db.exceptions.NotFoundException;
import com.clyde.uber.db.repositories.DriverRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class DriverService {

    private DriverRepository driverRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public DriverDTO getDriver(Long id) throws NotFoundException{
        Optional<Driver> driver = driverRepository.findById(id);
        if(!driver.isPresent()) {
            throw new NotFoundException("no driver for id: " + id);
        }
        DriverDTO driverDTO = modelMapper.map(driver.get(), DriverDTO.class);
        return driverDTO;
    }

}
