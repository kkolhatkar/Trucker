package application.trucker.readings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingsService {
	
	@Autowired
	private ReadingsRepository readingsRepository;

	public void saveReadings(Readings reading) {
		readingsRepository.save(reading);
		
	}
	
	public Iterable<Readings>  findAllReadings() {
		return readingsRepository.findAll();
	}
	
}
