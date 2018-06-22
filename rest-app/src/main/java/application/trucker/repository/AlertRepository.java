package application.trucker.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import application.trucker.entity.Alerts;

/**
 * @author Kunal
 *
 */
public interface AlertRepository extends JpaRepository<Alerts, String> {
	public List<Alerts> findByVin(String vin);

	/**
	 * Get List of HIGH Alerts with last 2 Hours
	 * 
	 * @param severity
	 * @param hour
	 * @param sort
	 */
	@Query(value = "select *  from alerts " + "where severity= ?1 "
			+ "and alert_occured > DATE_SUB(CONVERT_TZ(NOW(),'GMT','America/Chicago'), INTERVAL ?2 HOUR)"
			+ " ORDER BY ?#{#sort} ", nativeQuery = true)
	public List<Alerts> getAlertsByHour(String severity, Integer hour, Sort sort);

}
