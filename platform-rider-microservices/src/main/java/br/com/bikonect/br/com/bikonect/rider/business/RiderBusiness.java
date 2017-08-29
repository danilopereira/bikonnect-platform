package br.com.bikonect.br.com.bikonect.rider.business;

import br.com.bikonect.rider.dto.RiderRequest;
import br.com.bikonect.rider.dto.RiderResponse;

import java.util.List;

/**
 * Created by danilopereira on 21/07/17.
 */
public interface RiderBusiness {

    RiderResponse save(RiderRequest request);

    RiderResponse findById(Long id);

    void deleteRider(Long id);

    List<RiderResponse> listRiders();
}
