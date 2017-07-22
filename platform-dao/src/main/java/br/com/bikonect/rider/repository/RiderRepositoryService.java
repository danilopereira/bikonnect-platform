package br.com.bikonect.rider.repository;

import br.com.bikonect.entities.Rider;

import java.util.List;

/**
 * Created by danilopereira on 19/07/17.
 */
public interface RiderRepositoryService {

    public Rider findById(Long id);

    public List<Rider> findAll();

    public Rider save(Rider rider);
}
