package application.trucker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.trucker.entity.Readings;

/**
 * @author Kunal
 *
 */
public interface ReadingsRepository extends JpaRepository<Readings, Integer> {

}
