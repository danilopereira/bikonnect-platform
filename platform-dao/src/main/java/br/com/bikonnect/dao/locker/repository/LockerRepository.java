package br.com.bikonnect.dao.locker.repository;

import br.com.bikonnect.entities.Locker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by danilopereira on 26/08/17.
 */
@Repository
public interface LockerRepository extends CrudRepository<Locker, Long>{
}
