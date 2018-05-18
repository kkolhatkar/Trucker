package application.trucker.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kunal
 *
 */
@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	public String saveVehicle(Vehicle []vehicle){
		for (int i = 0; i < vehicle.length; i++) {
			vehicleRepository.save( vehicle[i]);
		}			
		return "okay Data Inserted";
	}
	
	public Iterable<Vehicle> findAllVehicle() {
		return vehicleRepository.findAll();
	}
	
	
	public Vehicle getVehicleByVin(String vin) {
		return vehicleRepository.findByVin(vin);
	}
}
