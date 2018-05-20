/**
 * 
 */
package application.trucker.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kunal
 *
 */
@RestController
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class VehicleNotFoundException extends RuntimeException implements ErrorController {
	
	VehicleNotFoundException(){
	}
	
	public VehicleNotFoundException(String message) {
		super(message);
	}

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return this.getMessage();
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
