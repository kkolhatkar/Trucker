package application.trucker.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kunal
 *
 */
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
	Vehicle findByVin(String vin);
}
