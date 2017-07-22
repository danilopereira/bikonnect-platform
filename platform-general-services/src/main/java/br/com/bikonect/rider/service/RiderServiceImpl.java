package br.com.bikonect.rider.service;

import br.com.bikonect.documentType.repository.DocumentTypeRepositoryService;
import br.com.bikonect.entities.Rider;
import br.com.bikonect.rider.dto.RiderRequest;
import br.com.bikonect.rider.dto.RiderResponse;
import br.com.bikonect.rider.repository.RiderRepositoryService;

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
        rider.setDocumentType(documentTypeRepositoryService.findByName(request.getDocumentType()));

        rider = riderRepositoryService.save(rider);

        return generatResponse(rider);
    }

    private RiderResponse generatResponse(Rider rider) {
        RiderResponse riderResponse = new RiderResponse();
        riderResponse.setId(rider.getId());
        riderResponse.setDocumentNumber(rider.getDocumentNumber());
        riderResponse.setDocumentType(rider.getDocumentType().getName());
        riderResponse.setName(rider.getName());
        riderResponse.setPublicName(rider.getPublicName());

        return riderResponse;
    }

    private String extractPublicName(String name) {
        return name.substring(0, name.indexOf(" "));
    }

    @Override
    public RiderResponse findById(Long id) {
        return generatResponse(riderRepositoryService.findById(id));
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
            RiderResponse riderResponse = generatResponse(rider);
            ridersResponse.add(riderResponse);
        }
        return ridersResponse;
    }


}
