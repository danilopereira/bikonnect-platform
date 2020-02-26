package br.com.bikonnect.dao.bike.repository;

import br.com.bikonnect.entities.Bike;

import java.util.List;

/**
 * Created by danilopereira on 19/07/17.
 */
public class BikeRepositoryServiceImpl implements BikeRepositoryService {

    protected BikeRepository bikeRepository;

    public BikeRepositoryServiceImpl(BikeRepository bikeRepository){
        this.bikeRepository = bikeRepository;
    }

    @Override
    public List<Bike> findAll() {
        return null;
    }

    @Override
    public Bike findById(String id) {
        return null;
    }
}
