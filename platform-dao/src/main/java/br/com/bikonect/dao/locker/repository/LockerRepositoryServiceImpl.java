package br.com.bikonect.dao.locker.repository;

import br.com.bikonect.entities.Locker;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by danilopereira on 26/08/17.
 */
public class LockerRepositoryServiceImpl implements LockerRepositoryService {

    private LockerRepository lockerRepository;

    public LockerRepositoryServiceImpl( LockerRepository lockerRepository){
        this.lockerRepository = lockerRepository;
    }

    @Override
    @Transactional
    public void save(Locker locker) {
        lockerRepository.save(locker);
    }

    @Override
    public Locker findById(Long lockerId) {
        return lockerRepository.findOne(lockerId);
    }
}
