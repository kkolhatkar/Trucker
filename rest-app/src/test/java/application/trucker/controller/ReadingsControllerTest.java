package application.trucker.controller;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import application.trucker.entity.Readings;
import application.trucker.repository.ReadingsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("integrationstest")
public class ReadingsControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ReadingsRepository readingsRepository;
	

    @Before
    public void setup() {
        Readings reading = new Readings();
        reading.setId("reading-id");
        reading.setLatitude(41.42);
        reading.setLongitude(78.23);
        reading.setVin("reading-Vin");
        readingsRepository.save(reading);
    }

    @After
    public void cleanup() {
    	readingsRepository.deleteAll();
    }
	
	@Test
	public void findAllReadings() throws Exception{
		 mvc.perform(MockMvcRequestBuilders.get("/readings"))
         .andExpect(MockMvcResultMatchers.status()
                                         .isOk())
         .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is("reading-id")));
	}
	
}
