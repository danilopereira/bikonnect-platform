package br.com.bikonnect.dao.locker.repository;

import br.com.bikonnect.entities.Locker;

/**
 * Created by danilopereira on 26/08/17.
 */
public interface LockerRepositoryService {

    void save(Locker locker);

    Locker findById(Long lockerId);
}
