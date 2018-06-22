package application.trucker.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.trucker.entity.Alerts;
import application.trucker.entity.Readings;
import application.trucker.entity.Rule;
import application.trucker.entity.Vehicles;
import application.trucker.exception.ResourceNotFoundException;
import application.trucker.repository.AlertRepository;

@Service
public class AlertsServiceImpl implements AlertsService {

	@Autowired
	private AlertRepository alertRepository;
	@Autowired
	private VehicleServiceImpl vehicleService;

	@Override
	public void validateRule(Readings reading) {
		String vin = reading.getVin();
		Timestamp alertTime = reading.getTimestamp();
		Vehicles vehicle = vehicleService.findVehicleByVin(vin);
		Boolean isValid = true;

		if (vehicle == null) {
			throw new ResourceNotFoundException("Vehicle with vin: " + vin + " NOT found");
		} else {
			if (reading.getEngineRpm() > vehicle.getRedlineRpm()) {
				saveAlert(Rule.RULE1, vin, alertTime);
			}
			else if (reading.getFuelVolume() < (vehicle.getMaxFuelVolume() / 10)) {
				saveAlert(Rule.RULE2, vin, alertTime);
			}
			else if ((reading.getTires().getFrontLeft() < 32 || reading.getTires().getFrontLeft() > 36)
					|| (reading.getTires().getFrontRight() < 32 || reading.getTires().getFrontRight() > 36)
					|| (reading.getTires().getRearLeft() < 32 || reading.getTires().getRearLeft() > 36)
					|| (reading.getTires().getRearRight() < 32 || reading.getTires().getRearRight() > 36)) {
				saveAlert(Rule.RULE3, vin, alertTime);
			}
			else if (reading.getEngineCoolantLow() || reading.getCheckEngineLightOn()) {
				saveAlert(Rule.RULE4, vin, alertTime);
			}
		}
	}

	@Async
	@Transactional
	public void saveAlert(Rule rule, String vin, Timestamp alertTime) {
		Alerts alert = new Alerts();
		alert.setVin(vin);
		alert.setAlertOccured(alertTime);
		alert.setReason(rule.getReason());
		alert.setSeverity(rule.getSeverity());
		alertRepository.save(alert);
	}

	@Transactional(readOnly = true)
	public List<Alerts> findByVin(String vin) {
		List<Alerts> vehicle = alertRepository.findByVin(vin);
		if(vehicle.isEmpty())
			throw new ResourceNotFoundException("Alert with vin"+vin+" Not Found");
		else
			return vehicle;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alerts> findAll() {
		return alertRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alerts> findAlertsByHour(String severity, Integer hour) {
		return alertRepository.getAlertsByHour(severity, hour, new Sort(Sort.Direction.ASC, "vin"));
	}

}
