package application.trucker.service;

import application.trucker.dto.GeoLocationDTO;
import application.trucker.entity.Readings;

public interface ReadingsService {
	
	public void saveReadings(Readings reading);
	public Iterable<Readings>  findAllReadings();
	public Iterable<GeoLocationDTO> getVehicleInfoByVinInTime(String vin, Integer min);

}
