package application.trucker.service;

import java.util.List;

import application.trucker.entity.Vehicles;

public interface VehicleService {
	
	public String saveVehicle(Vehicles []vehicle);
	public List<Vehicles> findAll();
	public Vehicles findVehicleByVin(String vin);

}
