package br.com.bikonect.rider.web;

import br.com.bikonect.rider.business.RiderBusiness;
import br.com.bikonect.rider.dto.RiderRequest;
import br.com.bikonect.rider.dto.RiderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by danilopereira on 19/07/17.
 */
@RestController
public class RiderController {

    @Autowired
    private RiderBusiness riderBusiness;

    @RequestMapping(value = "/api/v1/rider/{id}", method = RequestMethod.GET)
    public RiderResponse getRider(@PathVariable("id") Long id) {
        return riderBusiness.findById(id);
    }

    @RequestMapping(value = "/api/v1/rider", method = RequestMethod.POST)
    public RiderResponse createRider(@RequestBody @Valid RiderRequest request) {
        return riderBusiness.save(request);
    }

    @RequestMapping(value = "/api/v1/rider/{id}", method = RequestMethod.PUT)
    public RiderResponse updateRider(@RequestBody @Valid RiderRequest request) {
        return riderBusiness.save(request);
    }

    @RequestMapping(value = "/api/v1/rider/{id}", method = RequestMethod.DELETE)
    public void deleteRider(@PathVariable("id") Long id) {
        riderBusiness.deleteRider(id);
    }

    @RequestMapping(value = "/api/v1/rider", method = RequestMethod.GET)
    public List<RiderResponse> listRiders() {
        return riderBusiness.listRiders();
    }
}
