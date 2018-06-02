package application.trucker.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import application.trucker.entity.Vehicles;
import application.trucker.exception.ResourceNotFoundException;
import application.trucker.repository.VehicleRepository;

@RunWith(SpringRunner.class)
public class VehicleServiceTest {

	    @TestConfiguration
	    static class VehicleServiceImplTestConfiguration {

	        @Bean
	        public VehicleService getService() {
	            return new VehicleServiceImpl();
	        }
	    }

	    @Autowired
	    private VehicleService service;

	    @MockBean
	    private VehicleRepository repository;

	    private List<Vehicles> vehicles;

	    @Before
	    public void setup() {
	    	Vehicles vehicleObj = new Vehicles();
	        vehicleObj.setVin("Vin");
	        vehicleObj.setMake("Make");

	        vehicles = Collections.singletonList(vehicleObj);

	        Mockito.when(repository.findAll())
	               .thenReturn(vehicles);

	        Mockito.when(repository.findById(vehicleObj.getVin()))
	               .thenReturn(Optional.of(vehicleObj));
	    }

	    @After
	    public void cleanup() {
	    }

	    @Test
	    public void findAll() throws Exception {
	        List<Vehicles> result = service.findAll();
	        Assert.assertEquals("Vehicle list should match", vehicles, result);
	    }

	    @Test
	    public void findOne() throws Exception {
	    	Vehicles result = service.findVehicleByVin(vehicles.get(0)
	                                                   .getVin());
	        Assert.assertEquals("Vehicle should match", vehicles.get(0), result);
	    }

	    @Test(expected = ResourceNotFoundException.class)
	    public void findOneNotFound() throws Exception {
	    	Vehicles result = service.findVehicleByVin("asdfasdf");
	    }
	
	}