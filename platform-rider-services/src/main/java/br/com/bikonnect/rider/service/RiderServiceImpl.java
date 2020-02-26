package br.com.bikonnect.rider.service;

import br.com.bikonnect.dao.documentType.repository.DocumentTypeRepositoryService;
import br.com.bikonnect.entities.Locker;
import br.com.bikonnect.entities.Rider;
import br.com.bikonnect.locker.dto.LockerResponse;
import br.com.bikonnect.rider.dto.RiderRequest;
import br.com.bikonnect.rider.dto.RiderResponse;
import br.com.bikonnect.dao.rider.repository.RiderRepositoryService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by danilopereira on 22/07/17.
 */
public class RiderServiceImpl implements RiderService {

    private RiderRepositoryService riderRepositoryService;
    private DocumentTypeRepositoryService documentTypeRepositoryService;

    public RiderServiceImpl(RiderRepositoryService riderRepositoryService,
                            DocumentTypeRepositoryService documentTypeRepositoryService){
        this.riderRepositoryService = riderRepositoryService;
        this.documentTypeRepositoryService = documentTypeRepositoryService;
    }

    @Override
    public RiderResponse save(RiderRequest request) {
        Rider rider = new Rider();

        rider.setName(request.getName());
        rider.setPublicName(extractPublicName(request.getName()));
        rider.setActive(Boolean.TRUE);
        rider.setDocumentNumber(request.getDocumentNumber());
        rider.setCreatedAt(new Date(System.currentTimeMillis()));
        rider.setUpdatedAt(new Date(System.currentTimeMillis()));
        rider.setDocumentType(documentTypeRepositoryService.findByName(request.getDocumentType()).getName());

        rider = riderRepositoryService.save(rider);

        return generateResponse(rider);
    }

    private RiderResponse generateResponse(Rider rider) {
        RiderResponse riderResponse = new RiderResponse();
        riderResponse.setId(rider.getId());
        riderResponse.setDocumentNumber(rider.getDocumentNumber());
        riderResponse.setDocumentType(rider.getDocumentType());
        riderResponse.setName(rider.getName());
        riderResponse.setPublicName(rider.getPublicName());
        List<LockerResponse> lockerResponses = new ArrayList<>();
        List<Locker> lockers = rider.getLockers();
        lockers.forEach(locker -> {
            LockerResponse lockerResponse = new LockerResponse();
            lockerResponse.setId(locker.getId());
            lockerResponse.setPublicId(locker.getPublicId());

            lockerResponses.add(lockerResponse);
        });
        riderResponse.setLockerResponses(lockerResponses);

        return riderResponse;
    }

    private String extractPublicName(String name) {
        return name.substring(0, name.indexOf(" "));
    }

    @Override
    public RiderResponse findById(Long id) {
        return generateResponse(riderRepositoryService.findById(id));
    }

    @Override
    public void deleteRider(Long id) {
        Rider rider = riderRepositoryService.findById(id);
        rider.setActive(Boolean.FALSE);

        riderRepositoryService.save(rider);

    }

    @Override
    public List<RiderResponse> listRiders() {
        List<Rider> riders = riderRepositoryService.findAll();
        List<RiderResponse> ridersResponse = new ArrayList<RiderResponse>();
        for(Rider rider : riders){
            RiderResponse riderResponse = generateResponse(rider);
            ridersResponse.add(riderResponse);
        }
        return ridersResponse;
    }


}
