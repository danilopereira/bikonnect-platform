package br.com.bikonect.locker.business;

import br.com.bikonect.locker.dto.LockerLockerPositionsResponse;

/**
 * Created by danilopereira on 23/09/17.
 */
public interface LockerBusiness {

    public LockerLockerPositionsResponse getPositionsById(Long id);
}
