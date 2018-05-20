package application.trucker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import application.trucker.entity.Vehicle;
import application.trucker.service.VehicleServiceImpl;


/**
 * @author Kunal
 *
 */

@Controller
@ResponseBody
@RequestMapping(path="vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleServiceImpl vehicleService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Vehicle> getAllVehicle() {
		return vehicleService.findAllVehicle();
	}	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET,value="{vin}")
	public Vehicle getVehicle(@PathVariable("vin") String vin){
		 return vehicleService.getVehicleByVin(vin);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void saveVehicle(@RequestBody Vehicle []vehicle){
		vehicleService.saveVehicle(vehicle);
	}
	
}
