package application.trucker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import application.trucker.entity.Readings;
import application.trucker.service.ReadingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.HttpStatus;

/**
 * @author Kunal
 *
 */

@Controller
@RequestMapping(path = "readings")
@CrossOrigin
@Api(value="ReadingsController")
public class ReadingsController {

	@Autowired
	private ReadingsService readingsService;

	@ApiOperation("Save Readings")
	@RequestMapping(method = RequestMethod.POST, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public void saveReadings(@RequestBody Readings reading) {
		readingsService.saveReadings(reading);
	}

	@ApiOperation("List All Readings")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Readings> findAllReadings() {
		return readingsService.findAllReadings();
	}

	@ApiOperation("Returns Alerts for a specific vehicle (vin) within last x minutes. Specifying min is required parameter")
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "{vin}")
	public Iterable<Readings> getVehicleInfoByVinInTime(@PathVariable("vin") String vin,
			@RequestParam(value = "within", required = true) Integer min) {
		return readingsService.getVehicleInfoByVinInTime(vin, min);
	}

}
