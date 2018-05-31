package application.trucker.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.trucker.dto.GeoLocationDTO;
import application.trucker.entity.Readings;
import application.trucker.repository.ReadingsRepository;

@Service
public class ReadingsServiceImpl implements ReadingsService {

	@Autowired
	private ReadingsRepository readingsRepository;
	@Autowired
	private AlertsService ruleService;

	public void saveReadings(Readings reading) {
		readingsRepository.save(reading);
		ruleService.validateRule(reading);
	}

	public List<Readings> findAllReadings() {
		return readingsRepository.findAll();
	}

	public List<GeoLocationDTO> findVehicleInfoByVinInTime(String vin, Integer min) {
		Iterable<Readings> readings = readingsRepository.getVehicleInfoByVinInTime(vin, min);
		List<GeoLocationDTO> locationList = new LinkedList<>();
		
		for(Readings r : readings) {
			GeoLocationDTO object = new GeoLocationDTO();
			object.setVin(r.getVin());
			object.setTimestamp(r.getTimestamp());
			object.setLatitude(r.getLatitude());
			object.setLongitude(r.getLongitude());
			locationList.add(object);
		}
		
		return locationList;
	}

}
