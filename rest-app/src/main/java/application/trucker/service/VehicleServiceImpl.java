package application.trucker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.trucker.entity.Vehicles;
import application.trucker.exception.ResourceNotFoundException;
import application.trucker.repository.VehicleRepository;

/**
 * @author Kunal
 *
 */
@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public String saveVehicle(Vehicles[] vehicle) {
		for (int i = 0; i < vehicle.length; i++) {
			vehicleRepository.save(vehicle[i]);
		}
		return "Data Inserted";
	}

	public List<Vehicles> findAll() {
		return vehicleRepository.findAll();
	}

	public Vehicles findVehicleByVin(String vin) {
		Optional<Vehicles> vehicle = vehicleRepository.findById(vin);
		if (!vehicle.isPresent()) 
			throw new ResourceNotFoundException("Vehicle with vin: " + vin + " NOT found");
		else
			return vehicle.get();

	}
}
