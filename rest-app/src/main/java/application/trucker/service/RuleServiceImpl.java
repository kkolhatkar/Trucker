package application.trucker.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.trucker.entity.Alerts;
import application.trucker.entity.Readings;
import application.trucker.entity.Rule;
import application.trucker.entity.Vehicles;
import application.trucker.exception.VehicleNotFoundException;
import application.trucker.repository.RuleRepository;
@Service
public class RuleServiceImpl implements RuleService {

	@Autowired
	private RuleRepository ruleRepository;

	@Autowired
	private VehicleServiceImpl vehicleService;

	@Override
	public Boolean validateRule(Readings reading) {
		String vin = reading.getVin();
		Date alertTime =  reading.getTimestamp();
		Vehicles vehicle = vehicleService.getVehicleByVin(vin);
		Boolean isValid = true;

		if (vehicle == null) {
			throw new VehicleNotFoundException("Vehicle with vin: " + vin + " NOT found");
		} else {
			if (reading.getEngineRpm() > vehicle.getRedlineRpm()) {
				isValid = false;
				saveAlert(Rule.RULE1, vin, alertTime);
			}
			if (reading.getFuelVolume() < (vehicle.getMaxFuelVolume() / 10)) {
				isValid = false;
				saveAlert(Rule.RULE2, vin, alertTime);
			}
			if ((reading.getTires().getFrontLeft() < 32 || reading.getTires().getFrontLeft() > 36)
					|| (reading.getTires().getFrontRight() < 32 || reading.getTires().getFrontRight() > 36)
					|| (reading.getTires().getRearLeft() < 32 || reading.getTires().getRearLeft() > 36)
					|| (reading.getTires().getRearRight() < 32 || reading.getTires().getRearRight() > 36)) {
				isValid = false;
				saveAlert(Rule.RULE3, vin, alertTime);
			}
			if (reading.getEngineCoolantLow() || reading.getCheckEngineLightOn()) {
				isValid = false;
				saveAlert(Rule.RULE4, vin, alertTime);
			}
		}
		return isValid;
	}

	public void saveAlert(Rule rule, String vin, Date alertTime) {
		Alerts alert = new Alerts();
		alert.setVin(vin);
		alert.setAlertOccured(alertTime);
		alert.setReason(rule.getReason());
		alert.setSeverity(rule.getSeverity());
		ruleRepository.save(alert);
	}
	
	public Iterable<Alerts> getAlertByVin(String vin) {
		return ruleRepository.findByVin(vin);
	}

	@Override
	public Iterable<Alerts> getAllAlert() {
		return ruleRepository.findAll();
	}	

}
