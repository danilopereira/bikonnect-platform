package br.com.bikonect.dao.locker.repository;

import br.com.bikonect.entities.Locker;

/**
 * Created by danilopereira on 26/08/17.
 */
public class LockerRepositoryServiceImpl implements LockerRepositoryService {

    private LockerRepository lockerRepository;

    public LockerRepositoryServiceImpl( LockerRepository lockerRepository){
        this.lockerRepository = lockerRepository;
    }

    @Override
    public void save(Locker locker) {
        lockerRepository.save(locker);
    }

    @Override
    public Locker findById(String lockerId) {
        return lockerRepository.findOne(lockerId);
    }
}
