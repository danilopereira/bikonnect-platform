package br.com.bikonnect.dao.bike.repository;

import br.com.bikonnect.entities.Bike;

import java.util.List;

/**
 * Created by danilopereira on 19/07/17.
 */
public interface BikeRepositoryService {

    public List<Bike> findAll();

    public Bike findById(String id);
}
