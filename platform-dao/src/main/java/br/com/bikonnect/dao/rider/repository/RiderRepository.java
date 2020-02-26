package br.com.bikonnect.dao.rider.repository;

import br.com.bikonnect.entities.Rider;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by danilopereira on 19/07/17.
 */
public interface RiderRepository extends CrudRepository<Rider, Long> {
}
