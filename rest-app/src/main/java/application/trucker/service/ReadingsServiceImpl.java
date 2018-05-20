package application.trucker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.trucker.entity.Readings;
import application.trucker.repository.ReadingsRepository;

@Service
public class ReadingsServiceImpl {
	
	@Autowired
	private ReadingsRepository readingsRepository;

	public void saveReadings(Readings reading) {
		readingsRepository.save(reading);
		
	}
	
	public Iterable<Readings>  findAllReadings() {
		return readingsRepository.findAll();
	}
	
}
