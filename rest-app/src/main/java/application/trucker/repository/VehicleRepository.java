package application.trucker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.trucker.entity.Vehicles;

/**
 * @author Kunal
 *
 */
public interface VehicleRepository extends JpaRepository<Vehicles, String> {
}
