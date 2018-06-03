package application.trucker.service;

import java.sql.Timestamp;
import java.util.List;

import application.trucker.entity.Alerts;
import application.trucker.entity.Readings;
import application.trucker.entity.Rule;

public interface AlertsService {
	
	public void validateRule(Readings reading);
	public void saveAlert(Rule rule, String vin, Timestamp alertTime);
	public List<Alerts> findByVin(String vin);
	public List<Alerts> findAll();
	public List<Alerts> findAlertsByHour(String severity, Integer hour);

}
