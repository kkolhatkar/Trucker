package application.trucker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import application.trucker.entity.Readings;

/**
 * @author Kunal
 *
 */
public interface ReadingsRepository extends JpaRepository<Readings, String> {

	/**
	 * Return Vehicle's information which includes GEO-location within last specified
	 * minutes for particular vehicle
	 * 
	 * @param vin
	 * @param min
	 */
	@Query(value = "select * from readings r where r.vin = ?1 "
			+ "and r.timestamp >  DATE_SUB(CONVERT_TZ(NOW(),'GMT','America/Chicago'), INTERVAL ?2 MINUTE)", nativeQuery = true)
	public Iterable<Readings> getVehicleInfoByVinInTime(String vin, Integer min);
}
