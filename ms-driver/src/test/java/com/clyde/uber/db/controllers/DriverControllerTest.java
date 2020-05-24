package com.clyde.uber.db.controllers;

import com.clyde.uber.api.exceptions.NotFoundException;
import com.clyde.uber.api.model.core.Driver;
import com.clyde.uber.db.services.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;

import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

@ActiveProfiles({"test"})
@SpringBootTest
@AutoConfigureTestDatabase
public class DriverControllerTest {

    @MockBean private DriverService driverService;

    RestTemplate restTemplate = new RestTemplate();
    MockRestServiceServer mockServer = MockRestServiceServer.bindTo(restTemplate).build();

    @BeforeEach
    void setup() throws NotFoundException {
        Mockito.when(driverService.getDriver(2L)).thenReturn(new Driver());
    }

    @Test
    public void getDriver2() {
        mockServer.expect(requestTo("/ms-driver/driver/2")).andRespond(withSuccess());
    }


}
