package br.com.bikonect.br.com.bikonect.rider.business;

import br.com.bikonect.rider.dto.RiderRequest;
import br.com.bikonect.rider.dto.RiderResponse;
import br.com.bikonect.rider.service.RiderService;

import java.util.List;

/**
 * Created by danilopereira on 22/07/17.
 */
public class RiderBusinessImpl implements RiderBusiness {
    private RiderService riderService;

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
