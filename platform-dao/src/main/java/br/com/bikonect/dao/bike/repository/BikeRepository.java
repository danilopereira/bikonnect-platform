package br.com.bikonect.dao.bike.repository;

import br.com.bikonect.entities.Bike;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by danilopereira on 19/07/17.
 */
public interface BikeRepository extends CrudRepository<Bike, String> {
}
