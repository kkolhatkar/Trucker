package application.trucker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.trucker.entity.Vehicle;
import application.trucker.exception.VehicleNotFoundException;
import application.trucker.repository.VehicleRepository;

/**
 * @author Kunal
 *
 */
@Service
public class VehicleServiceImpl {
	
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
		Vehicle vehicle = vehicleRepository.findByVin(vin);
		if(vehicle == null){
			throw new VehicleNotFoundException("Vehicle with vin: "+vin+" NOT found");
		}else {
			return vehicle;
		}
	}
}
