package br.com.bikonnect.rider.business;

import br.com.bikonnect.rider.dto.RiderRequest;
import br.com.bikonnect.rider.dto.RiderResponse;
import br.com.bikonnect.rider.service.RiderService;

import java.util.List;

/**
 * Created by danilopereira on 22/07/17.
 */
public class RiderBusinessImpl implements RiderBusiness {
    private RiderService riderService;

    public RiderBusinessImpl(RiderService riderService) {
        this.riderService = riderService;
    }

    @Override
    public RiderResponse save(RiderRequest request) {
        return riderService.save(request);
    }

    @Override
    public RiderResponse findById(Long id) {
        return riderService.findById(id);
    }

    @Override
    public void deleteRider(Long id) {
        riderService.deleteRider(id);
    }

    @Override
    public List<RiderResponse> listRiders() {
        return riderService.listRiders();
    }
}
