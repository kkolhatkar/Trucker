package application.trucker.service;

import java.util.Date;

import application.trucker.entity.Alerts;
import application.trucker.entity.Readings;
import application.trucker.entity.Rule;

public interface RuleService {
	
	public Boolean validateRule(Readings reading);
	public void saveAlert(Rule rule, String vin, Date alertTime);
	public Iterable<Alerts> getAlertByVin(String vin);
	public Iterable<Alerts> getAllAlert();

}
