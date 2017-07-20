package br.com.bikonect.bike.repository;

import br.com.bikonect.entities.Bike;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by danilopereira on 19/07/17.
 */
public interface BikeRepository extends MongoRepository<Bike, String> {
}
