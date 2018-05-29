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

import application.trucker.entity.Vehicles;
import application.trucker.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author Kunal
 *
 */

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping(path="vehicles")
@Api(value="VehiclesController")
public class VehiclesController {
	
	@Autowired
	private VehicleService vehicleService;

	@ApiOperation("List All Vehicles")
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Vehicles> getAllVehicle() {
		return vehicleService.findAllVehicle();
	}	
	
	@ApiOperation("Returns specific vehicle by (Vin)")
	@RequestMapping(method = RequestMethod.GET,value="{vin}")
	public Vehicles getVehicle(@PathVariable("vin") String vin){
		 return vehicleService.getVehicleByVin(vin);
	}
	
	@ApiOperation("Ingest Vehicles")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void saveVehicle(@RequestBody Vehicles []vehicle){
		vehicleService.saveVehicle(vehicle);
	}
}
