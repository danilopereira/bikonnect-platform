package br.com.bikonect.locker.web;

import br.com.bikonect.locker.business.LockerBusiness;
import br.com.bikonect.locker.dto.LockerLockerPositionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by danilopereira on 23/09/17.
 */
@RestController
public class LockerController {

    @Autowired
    private LockerBusiness lockerBusiness;

    @GetMapping("/api/v1/locker/{id}")
    public LockerLockerPositionsResponse getLocker(@PathVariable("id") Long lockerId){
        return lockerBusiness.getPositionsById(lockerId);
    }


}
