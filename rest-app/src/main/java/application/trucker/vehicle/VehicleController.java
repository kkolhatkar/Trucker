package application.trucker.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author Kunal
 *
 */

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@CrossOrigin
	@ResponseBody
	@GetMapping(path = "/vehicles")
	public Iterable<Vehicle> getAllVehicle() {
		return vehicleService.findAllVehicle();
	}	
	
	@CrossOrigin
	@ResponseBody
	@PutMapping(path="/vehicles")
	@ResponseStatus(HttpStatus.OK)
	public void saveVehicle(@RequestBody Vehicle []vehicle){
		vehicleService.saveVehicle(vehicle);
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,path="/vehicle/")
	public Vehicle getVehicle(@RequestParam("vin") String vin){
		 return vehicleService.getVehicleByVin(vin);
		
	}
	
}
