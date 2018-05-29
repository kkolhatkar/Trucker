package application.trucker.service;

import java.util.Date;

import application.trucker.entity.Alerts;
import application.trucker.entity.Readings;
import application.trucker.entity.Rule;

public interface AlertsService {
	
	public Boolean validateRule(Readings reading);
	public void saveAlert(Rule rule, String vin, Date alertTime);
	public Iterable<Alerts> findByVin(String vin);
	public Iterable<Alerts> findAll();
	public Iterable<Alerts> findAlertsByHour(String severity, Integer hour);

}
