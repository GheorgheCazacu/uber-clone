package com.clyde.uber.db.services;

import com.clyde.uber.api.exceptions.NotFoundException;
import com.clyde.uber.api.model.core.Vehicle;
import com.clyde.uber.db.entities.VehicleEntity;
import com.clyde.uber.db.repositories.VehicleRepository;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Optional;

//@SpringBootTest
//@ActiveProfiles("test")
public class VehicleServiceTest {

    private VehicleRepository vehicleRepository = Mockito.spy(VehicleRepository.class);
    private VehicleService classUnderTest = new VehicleService(vehicleRepository);

    @Test
    public void testOne() {
        //
        VehicleEntity vehicle = new VehicleEntity();
        vehicle.setId(2L);
        vehicle.setActive("T");
        vehicle.setColor("RED");
        vehicle.setDriverId(3L);
        vehicle.setName("vehicle");
        vehicle.setRegistrationNumber("BZ06ROV");

        Mockito.when(vehicleRepository.findById(2L)).thenReturn(Optional.of(vehicle));
        //
        Vehicle v = null;
        try {
            v = classUnderTest.getVehicle(2L);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        // assert
        assertEquals("vehicle", v.getName());
        assertEquals("BZ06ROV", v.getRegistrationNumber());
        assertEquals("RED", v.getColor());
        assertEquals("T", v.getActive());
        assertEquals(3L, v.getDriverId());
        assertEquals(2L, v.getId());

    }

}
