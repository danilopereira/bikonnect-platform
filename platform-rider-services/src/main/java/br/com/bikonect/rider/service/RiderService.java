package br.com.bikonect.rider.service;

import br.com.bikonect.rider.dto.RiderRequest;
import br.com.bikonect.rider.dto.RiderResponse;

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
