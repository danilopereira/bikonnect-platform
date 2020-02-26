package br.com.bikonnect.locker.business;

import br.com.bikonnect.locker.dto.LockerLockerPositionsResponse;

/**
 * Created by danilopereira on 23/09/17.
 */
public interface LockerBusiness {

    public LockerLockerPositionsResponse getPositionsById(Long id);
}
