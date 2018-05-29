package application.trucker.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Iterable<Readings> findAllReadings() {
		return readingsRepository.findAll();
	}

	public Iterable<Readings> getVehicleInfoByVinInTime(String vin, Integer min) {
		return readingsRepository.getVehicleInfoByVinInTime(vin, min);
		
	}

}
