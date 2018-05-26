package application.trucker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import application.trucker.entity.Alerts;

/**
 * @author Kunal
 *
 */
public interface RuleRepository extends JpaRepository<Alerts, String> {
	public Iterable<Alerts> findByVin(String vin);
}
