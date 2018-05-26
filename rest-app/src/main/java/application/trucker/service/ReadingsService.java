package application.trucker.service;

import application.trucker.entity.Readings;

public interface ReadingsService {
	
	public void saveReadings(Readings reading);
	public Iterable<Readings>  findAllReadings();

}
