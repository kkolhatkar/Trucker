package application.trucker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import application.trucker.entity.Alerts;
import application.trucker.service.AlertsService;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping(path = "alerts")
public class AlertsController {

	@Autowired
	private AlertsService alertService;

	/**
	 * Returns All Alerts severity and within(within last how many hour) are
	 * optional parameter
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Alerts> getAlertsByHour(@RequestParam(value = "severity", required = false) String severity,
			@RequestParam(value = "within", required = false) Integer hour) {
		if (severity == null && hour == null) {
			return alertService.findAll();
		} else {
			return alertService.findAlertsByHour(severity, hour);
		}
	}

	/**
	 * Returns Alerts for a specific vehicle (Vin)
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{vin}")
	public Iterable<Alerts> getAlertByVin(@PathVariable("vin") String vin) {
		return alertService.findByVin(vin);
	}
}
