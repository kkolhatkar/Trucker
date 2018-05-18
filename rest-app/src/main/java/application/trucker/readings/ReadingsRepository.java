package application.trucker.readings;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kunal
 *
 */
public interface ReadingsRepository extends JpaRepository<Readings, Integer> {

}
