package br.com.bikonnect.locker.business;

import br.com.bikonnect.dao.locker.repository.LockerRepositoryService;
import br.com.bikonnect.entities.Locker;
import br.com.bikonnect.locker.dto.LockerLockerPositionsResponse;
import br.com.bikonnect.lockerposition.dto.LockerPositionResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danilopereira on 23/09/17.
 */
public class LockerBusinessImpl implements LockerBusiness {

    private LockerRepositoryService lockerRepositoryService;

    public LockerBusinessImpl(LockerRepositoryService lockerRepositoryService){
        this.lockerRepositoryService = lockerRepositoryService;
    }

    @Override
    public LockerLockerPositionsResponse getPositionsById(Long id) {
        LockerLockerPositionsResponse response = new LockerLockerPositionsResponse();
        List<LockerPositionResponse> lockerPositionResponses = new ArrayList<>();
        Locker locker = lockerRepositoryService.findById(id);

        locker.getLockerPositions().forEach(lockerPosition -> {
            LockerPositionResponse lockerPositionResponse = new LockerPositionResponse();

            lockerPositionResponse.setLatitude(lockerPosition.getLatitude());
            lockerPositionResponse.setLongitude(lockerPosition.getLongitude());
            lockerPositionResponse.setDate(lockerPosition.getCreatedAt().toString());

            lockerPositionResponses.add(lockerPositionResponse);
        });

        response.setId(locker.getId());
        response.setPublicId(locker.getPublicId());
        response.setLockerPositions(lockerPositionResponses);

        return response;
    }
}
