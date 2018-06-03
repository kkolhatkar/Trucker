package application.trucker.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.trucker.dto.GeoLocationDTO;
import application.trucker.entity.Readings;
import application.trucker.repository.ReadingsRepository;

@Service
public class ReadingsServiceImpl implements ReadingsService {

	@Autowired
	private ReadingsRepository readingsRepository;
	@Autowired
	private AlertsService alertService;

	public void saveReadings(Readings reading) {
		readingsRepository.save(reading);
		alertService.validateRule(reading);
	}
	
	@Transactional(readOnly = true)
	public List<Readings> findAllReadings() {
		return readingsRepository.findAll();
	}
	
	@Transactional(readOnly = true)
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
