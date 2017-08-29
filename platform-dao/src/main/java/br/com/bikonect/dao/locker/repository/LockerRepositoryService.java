package br.com.bikonect.dao.locker.repository;

import br.com.bikonect.entities.Locker;

/**
 * Created by danilopereira on 26/08/17.
 */
public interface LockerRepositoryService {

    void save(Locker locker);

    Locker findById(String lockerId);
}
