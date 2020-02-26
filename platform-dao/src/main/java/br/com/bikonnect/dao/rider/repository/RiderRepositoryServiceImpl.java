package br.com.bikonnect.dao.rider.repository;

import br.com.bikonnect.entities.Rider;

import java.util.List;

/**
 * Created by danilopereira on 19/07/17.
 */
public class RiderRepositoryServiceImpl implements RiderRepositoryService {

    protected RiderRepository riderRepository;

    public RiderRepositoryServiceImpl(RiderRepository riderRepository){
        this.riderRepository = riderRepository;
    }

    @Override
    public Rider findById(Long id) {
        return riderRepository.findOne(id);
    }


    @Override
    public List<Rider> findAll() {

        return (List<Rider>) riderRepository.findAll();
    }

    @Override
    public Rider save(Rider rider) {
        return riderRepository.save(rider);
    }
}
