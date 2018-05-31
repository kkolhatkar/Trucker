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

import application.trucker.entity.Alerts;
import application.trucker.repository.AlertRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("integrationstest")
public class AlertControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private AlertRepository alertRepository;
	

    @Before
    public void setup() {
        Alerts alert = new Alerts();
        alert.setAlertId("alert-id");
        alert.setReason("Engine Failure");
        alert.setSeverity("HIGH");
        alert.setVin("Alert-Vin");
        alertRepository.save(alert);
    }

    @After
    public void cleanup() {
    	alertRepository.deleteAll();
    }
	
	@Test
	public void getAlertByVin() throws Exception{
		 mvc.perform(MockMvcRequestBuilders.get("/alerts/Alert-Vin"))
         .andExpect(MockMvcResultMatchers.status()
                                         .isOk())
         .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].alertId", Matchers.is("alert-id")));
	}
	
	@Test
    public void findOne404() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/alerts/asdfdsfasdfasd"))
           .andExpect(MockMvcResultMatchers.status()
                                           .isNotFound());
    }
	

}
