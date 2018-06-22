package application.trucker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Kunal Kolhatkar
 *
 */
@SpringBootApplication
@EnableAsync
public class TruckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruckerApplication.class, args);
	}
}
