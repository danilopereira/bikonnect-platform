package br.com.bikonect.br.com.bikonect.rider.web;

import br.com.bikonect.rider.dto.RiderRequest;
import br.com.bikonect.rider.dto.RiderResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by danilopereira on 19/07/17.
 */
@RestController
public class RiderController {

    @RequestMapping(value = "/api/v1/rider/{id}", method = RequestMethod.GET)
    public RiderResponse getRider(@PathVariable("id") String id){
        return null;
    }

    @RequestMapping(value = "/api/v1/rider", method = RequestMethod.POST)
    public RiderResponse createRider(@RequestBody @Valid RiderRequest request){
        return null;
    }
}
