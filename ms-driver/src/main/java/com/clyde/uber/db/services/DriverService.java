package com.clyde.uber.db.services;

import com.clyde.uber.api.model.core.Driver;
import com.clyde.uber.api.exceptions.NotFoundException;
import com.clyde.uber.db.entities.DriverEntity;
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
    public Driver getDriver(Long id) throws com.clyde.uber.api.exceptions.NotFoundException {
        Optional<DriverEntity> driver = driverRepository.findById(id);
        if(!driver.isPresent()) {
            throw new NotFoundException("no driver for id: " + id);
        }
        Driver driverDTO = modelMapper.map(driver.get(), Driver.class);
        return driverDTO;
    }

}
