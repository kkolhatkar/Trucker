package application.trucker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.trucker.entity.Vehicle;

/**
 * @author Kunal
 *
 */
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
	Vehicle findByVin(String vin);
}
