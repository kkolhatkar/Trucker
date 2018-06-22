package application.trucker.service;

import java.util.List;

import application.trucker.dto.GeoLocationDTO;
import application.trucker.entity.Readings;

public interface ReadingsService {
	
	public void saveReadings(Readings reading);
	public List<Readings>  findAllReadings();
	public List<GeoLocationDTO> findVehicleInfoByVinInTime(String vin, Integer min);

}
