package br.com.bikonnect.rider.service;

import br.com.bikonnect.rider.dto.RiderRequest;
import br.com.bikonnect.rider.dto.RiderResponse;

import java.util.List;

/**
 * Created by danilopereira on 22/07/17.
 */
public interface RiderService {
    RiderResponse save(RiderRequest request);

    RiderResponse findById(Long id);

    void deleteRider(Long id);

    List<RiderResponse> listRiders();
}
