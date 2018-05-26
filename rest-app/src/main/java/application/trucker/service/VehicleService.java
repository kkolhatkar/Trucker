package application.trucker.service;

import application.trucker.entity.Vehicles;

public interface VehicleService {
	
	public String saveVehicle(Vehicles []vehicle);
	public Iterable<Vehicles> findAllVehicle();
	public Vehicles getVehicleByVin(String vin);

}
