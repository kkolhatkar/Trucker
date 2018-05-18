package application.trucker.readings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * @author Kunal
 *
 */

@Controller
public class ReadingsController {

	@Autowired
	private ReadingsService readingsService;
	
	@CrossOrigin	
	@RequestMapping(value = "/readings", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
	public void saveReadings(@RequestBody Readings reading) {
		readingsService.saveReadings(reading);
	}
	
	@CrossOrigin	
	@RequestMapping(value = "/readings", method = RequestMethod.GET)
    @ResponseBody
	public Iterable<Readings>  findAllReadings() {
		return readingsService.findAllReadings();
	}
	
}
