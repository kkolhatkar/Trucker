package application.Trucker;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import application.trucker.controller.AlertsController;
import application.trucker.controller.ReadingsController;
import application.trucker.controller.VehiclesController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private AlertsController alertController;
	@Autowired
	private ReadingsController readingsController;
	@Autowired
	private VehiclesController vehicleController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(alertController).isNotNull();
        assertThat(vehicleController).isNotNull();
        assertThat(readingsController).isNotNull();
    }

}
